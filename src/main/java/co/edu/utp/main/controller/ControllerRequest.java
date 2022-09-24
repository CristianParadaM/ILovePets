package co.edu.utp.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import co.edu.utp.main.controller.dto.ProductDto;
import co.edu.utp.main.model.Mark;
import co.edu.utp.main.model.Product;
import co.edu.utp.main.model.Shop;

@RestController
public class ControllerRequest {

    private Gson gson;
    private Shop shop;

    public ControllerRequest() {
        gson = new Gson();
        shop = Shop.getInstance();
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
            Product product = shop.getProductById(Integer.parseInt(value));
            if (product != null) {
                return gson.toJson(convertToDTO(product));
            }
            return null;
        }
    }

    public List<ProductDto> convertToDTO(List<Product> products) {
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            String typePet = product.getTypePet() == 'D' ? "perro"
                    : product.getTypePet() == 'C' ? "gato" : product.getTypePet() == 'B' ? "ave" : "pez";
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
        String typePet = product.getTypePet() == 'D' ? "perro"
                : product.getTypePet() == 'C' ? "gato" : product.getTypePet() == 'B' ? "ave" : "pez";
        DecimalFormat formato = new DecimalFormat("#,###");
        String priceFormat = formato.format(product.getPrice());
        String priceDesFormat = formato.format(product.getPriceDes());
        return new ProductDto(product.getIdProduct(), product.getUrlimg(), product.getName(),
                product.getDescription(), typePet, product.getWeigth(), priceFormat, priceDesFormat,
                product.getQuantyStock(), product.getMark().getName());
    }

    @PostMapping("/addProduct")
    public String addProduct(
            @RequestParam(value = "input-code") Integer code,
            @RequestParam(value = "namep") String name,
            @RequestParam(value = "file") MultipartFile imagen,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "typepet") String type,
            @RequestParam(value = "mark") String mark,
            @RequestParam(value = "price") float price,
            @RequestParam(value = "quanty") int quanty) {

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

        shop.addProduct(new Product(
                code,
                "resource/"+imagen.getOriginalFilename(),
                name,
                desc,
                type.equals("Perro") ? 'D' : type.equals("Gato") ? 'C' : type.equals("Ave") ? 'B' : 'F',
                "1.2kg",
                price,
                0f,
                quanty,
                new Mark(20, mark)));
        return "admin";
    }
}
