package co.edu.utp.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.utp.main.controller.dto.ProductDto;
import co.edu.utp.main.model.Client;
import co.edu.utp.main.model.EnumTypeToPay;
import co.edu.utp.main.model.Mark;
import co.edu.utp.main.model.Product;
import co.edu.utp.main.model.Sale;
import co.edu.utp.main.model.Shop;

@RestController
public class ControllerRequest {

    private Gson gson;
    private Shop shop;
    private int idFocus;

    public ControllerRequest() {
        gson = new Gson();
        shop = Shop.getInstance();
    }

    @GetMapping("/delete")
    public String removeProduct(){
        return shop.remove(idFocus)?"3":"-3";
    }

    @GetMapping("/request")
    public String getProductRequest(String value) {
        if (!value.matches("[0-9]+")) {
            switch (value) {
                case "destacados":
                    return gson.toJson(convertToDTO(shop.getFeatureProducts(1)));
                case "perros":
                    return gson.toJson(convertToDTO(shop.getPetProducts(1, 'D')));
                case "gatos":
                    return gson.toJson(convertToDTO(shop.getPetProducts(1, 'C')));
                case "aves":
                    return gson.toJson(convertToDTO(shop.getPetProducts(1, 'B')));
                default:
                    return gson.toJson(convertToDTO(shop.getPetProducts(1, 'F')));
            }
        } else {
            idFocus = Integer.parseInt(value);
            Product product = shop.getProductById(idFocus);
            if (product != null) {
                return gson.toJson(convertToDTO(product));
            }
            return null;
        }
    }

    public List<ProductDto> convertToDTO(List<Product> products) {
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            String typePet = product.getTypePet() == 'D' ? "Perro"
                    : product.getTypePet() == 'C' ? "Gato" : product.getTypePet() == 'B' ? "Ave" : "Pez";
            DecimalFormat formato = new DecimalFormat("#,###");
            String priceFormat = formato.format(product.getPrice());
            String priceDesFormat = formato.format(product.getPriceDes());
            productDtos.add(new ProductDto(product.getIdProduct(), product.getUrlimg(), product.getName(),
                    product.getDescription(), typePet, product.getWeigth(), priceFormat, priceDesFormat,
                    product.getQuantyStock(), product.getMark().getName()));
        }
        return productDtos;
    }

    public ProductDto convertToDTO(Product product) {
        String typePet = product.getTypePet() == 'D' ? "Perro"
                : product.getTypePet() == 'C' ? "Gato" : product.getTypePet() == 'B' ? "Ave" : "Pez";
        DecimalFormat formato = new DecimalFormat("#,###");
        String priceFormat = formato.format(product.getPrice());
        String priceDesFormat = formato.format(product.getPriceDes());
        return new ProductDto(product.getIdProduct(), product.getUrlimg(), product.getName(),
                product.getDescription(), typePet, product.getWeigth(), priceFormat, priceDesFormat,
                product.getQuantyStock(), product.getMark().getName());
    }

    @PostMapping("/modify")
    public ModelAndView modifyProduct(
            @RequestParam(value = "namep") String name,
            @RequestParam(value = "img") MultipartFile imagen,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "typepet") String type,
            @RequestParam(value = "mark") String mark,
            @RequestParam(value = "price") String priceS,
            @RequestParam(value = "quanty") int quanty,
            @RequestParam(value = "pricepre", required = false) String pricepreS
            ){
                float price = Float.parseFloat(priceS.replace(".", ""));
                float pricepre = Float.parseFloat(pricepreS.replace(".", ""));
                Product pBef = shop.getProductById(idFocus);
                char typeChar = type.equals("Perro") ? 'D' : type.equals("Gato") ? 'C' : type.equals("Ave") ? 'B' : 'F';
                Object changes[] = new Object[]{null,null,null,null,null,null,null,null};

                if (!name.equals(pBef.getName())) {
                    changes[0] = name;
                }
                if (!imagen.isEmpty() && !("resource/"+imagen.getOriginalFilename()).equals(pBef.getUrlimg())) {
                    try {
                        Path pathImg = Paths.get("src//main//resources//static/resource");
                        String pathAbs = pathImg.toFile().getAbsolutePath();
                        byte[] bytesImg = imagen.getBytes();
                        Path pathComplete = Paths.get(pathAbs + "//" + imagen.getOriginalFilename());
                        Files.write(pathComplete, bytesImg);
                        changes[1] = "resource/"+imagen.getOriginalFilename();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (!desc.equals(pBef.getDescription())) {
                    changes[2] = desc;
                }
                if (typeChar != pBef.getTypePet()) {
                    changes[3] = typeChar;
                }
                if (!mark.equals(pBef.getMark().getName())) {
                    changes[4] = mark;
                }
                if (price != pBef.getPrice()) {
                    changes[5] = price;
                }
                if (quanty != pBef.getQuantyStock()) {
                    changes[6] = quanty;
                }
                if (pricepre != pBef.getPriceDes()) {
                    changes[7] = pricepre;
                }
                ModelAndView response = new ModelAndView("admin").addObject("idGenerated", shop.getIdProductSerial()).addObject("notify",   shop.modify(idFocus, changes)?2:-2);
                return response;
            };


    @PostMapping("/addProduct")
    public ModelAndView addProduct(
            @RequestParam(value = "input-code") Integer code,
            @RequestParam(value = "namep") String name,
            @RequestParam(value = "file") MultipartFile imagen,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "typepet") String type,
            @RequestParam(value = "mark") String mark,
            @RequestParam(value = "price") String price,
            @RequestParam(value = "quanty") int quanty,
            @RequestParam(value = "weight") String weight
            ) {

        float priceS = Float.parseFloat(price);
        if (!imagen.isEmpty()) {
            try {
                Path pathImg = Paths.get("src//main//resources//static/resource");
                String pathAbs = pathImg.toFile().getAbsolutePath();
                byte[] bytesImg = imagen.getBytes();
                Path pathComplete = Paths.get(pathAbs + "//" + imagen.getOriginalFilename());
                Files.write(pathComplete, bytesImg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Product p = new Product(code,"resource/" + imagen.getOriginalFilename(),name,desc,
            type.equals("Perro") ? 'D' : type.equals("Gato") ? 'C' : type.equals("Ave") ? 'B' : 'F',
            weight ,priceS,0f,quanty,new Mark(shop.getIdMarkSerial(), mark));

        ModelAndView response = new ModelAndView("admin").addObject("idGenerated", shop.getIdProductSerial()).addObject("notify",  shop.addProduct(p)?1:-1 );
        return response;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam(value = "username") String user,
    @RequestParam(value = "pass") String pass){
        if (user.equals(Shop.USER_ADMIN) && pass.equals(Shop.PASS_ADMIN)) {
            return new ModelAndView("admin").addObject("idGenerated", shop.getIdProductSerial()).addObject("notify",  0 );
        }else{
            ModelAndView m = new ModelAndView("index").addObject("textSearch", new Message()).addObject("productsDestacados", convertToDTO(shop.getFeatureProducts(0)))
            .addObject("productsPerros", convertToDTO(shop.getPetProducts(0, 'D')))
            .addObject("productsGatos", convertToDTO(shop.getPetProducts(0, 'C')))
            .addObject("productsAves", convertToDTO(shop.getPetProducts(0, 'B')))
            .addObject("productsPeces", convertToDTO(shop.getPetProducts(0, 'F')))
            .addObject("notify", -1);
            return m;
        }
    }

    @PostMapping("/sale")
    public ModelAndView addSale(
        @RequestParam(value = "name") String names,
        @RequestParam(value = "lastname") String lastnames,
        @RequestParam(value = "id") int id,
        @RequestParam(value = "address") String address,
        @RequestParam(value = "birthdate") String birthdate,
        @RequestParam(value = "paymethod") String paymethod,
        @RequestParam(value = "subtotal") String subtotal,
        @RequestParam(value = "taxes") String taxes,
        @RequestParam(value = "total") String total,
        @RequestParam(value = "products") String products
    ){
        ArrayList<Integer> p = new ArrayList<>();
        Map<Object, Object> g =gson.fromJson(products, new TypeToken<Map<Object, Object>>(){}.getType());
        g.forEach((k,v)->{
            for (int i = 0; i < (double)v; i++) {
                p.add(Integer.parseInt((String)k));
            }
        });
        Client client = shop.searchClientById(id);
        if (client==null) {
            client = new Client(id, names, lastnames, LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), address);
        }
        float subtotalS = Float.parseFloat(subtotal.replace(",", "").replace("$", ""));
        float taxesS = Float.parseFloat(taxes.replace(",", "").replace("$", ""));
        float totalS = Float.parseFloat(total.replace(",", "").replace("$", ""));
        Sale sale = new Sale(shop.getIdSaleSerial(), p, LocalDateTime.now(), 
        paymethod.equals("cash")?EnumTypeToPay.CASH:paymethod.equals("debit")?EnumTypeToPay.DEBIT_CARD:EnumTypeToPay.CREDIT_CARD,
        subtotalS, taxesS, totalS, client.getId());
        return new ModelAndView("index").addObject("textSearch", new Message())
        .addObject("productsDestacados", convertToDTO(shop.getFeatureProducts(0)))
        .addObject("productsPerros", convertToDTO(shop.getPetProducts(0, 'D')))
        .addObject("productsGatos", convertToDTO(shop.getPetProducts(0, 'C')))
        .addObject("productsAves", convertToDTO(shop.getPetProducts(0, 'B')))
        .addObject("productsPeces", convertToDTO(shop.getPetProducts(0, 'F')))
        .addObject("notify", shop.addSale(sale)?2:-2);
    }
}
