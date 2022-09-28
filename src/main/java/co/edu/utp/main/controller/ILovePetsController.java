package co.edu.utp.main.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import co.edu.utp.main.controller.dto.ProductDto;
import co.edu.utp.main.model.Product;
import co.edu.utp.main.model.Shop;

@Controller
public class ILovePetsController {

    private Shop shop;

    public ILovePetsController() {
        shop = Shop.getInstance();
    }

    @GetMapping("/admin")
    public String goToAdmin(Model model) {
        model.addAttribute("idGenerated", shop.getIdProductSerial());
        model.addAttribute("notify", 0);
        return "admin";
    }

    @GetMapping("/catalog")
    public String goToCatalog(Model model) {
        model.addAttribute("textSearch", new Message());
        model.addAttribute("notify", 0);
        model.addAttribute("productsDestacados", convertToDTO(shop.getFeatureProducts(0)));
        model.addAttribute("productsPerros", convertToDTO(shop.getPetProducts(0, 'D')));
        model.addAttribute("productsGatos", convertToDTO(shop.getPetProducts(0, 'C')));
        model.addAttribute("productsAves", convertToDTO(shop.getPetProducts(0, 'B')));
        model.addAttribute("productsPeces", convertToDTO(shop.getPetProducts(0, 'F')));
        return "index";
    }

    @GetMapping("/")
    public String goToindex(Model model) {
        return goToCatalog(model);
    }

    @GetMapping("/search")
    public String showSearchedProducts(@ModelAttribute Message textsearch, Model model) {
        model.addAttribute("isDestacados", true);
        model.addAttribute("path", "/resource/btnfiltromascotas.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Mejores coincidencias para: "+textsearch.getText());
        System.out.println(shop.searchProducts(textsearch.getText()).size());
        model.addAttribute("products", convertToDTO(shop.searchProducts(textsearch.getText())));
        return "search";
    }

    @GetMapping("/allProductsDestacados")
    public String showAllDestacados(Model model) {
        model.addAttribute("isDestacados", true);
        model.addAttribute("path", "/resource/btnfiltromascotas.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Todos los productos destacados");
        model.addAttribute("products", convertToDTO(shop.getFeatureProducts(1)));
        return "search";
    }
    
    @GetMapping("/allProductsPerros")
    public String showAllPerros(Model model) {
        model.addAttribute("isDestacados", false);
        model.addAttribute("path", "/resource/btnfiltroperro.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Todos los productos de perros");
        model.addAttribute("products", convertToDTO(shop.getPetProducts(1, 'D')));
        return "search";
    }

    @GetMapping("/allProductsGatos")
    public String showAllGatos(Model model) {
        model.addAttribute("isDestacados", false);
        model.addAttribute("path", "/resource/btnfiltrogato.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Todos los productos de gatos");
        model.addAttribute("products", convertToDTO(shop.getPetProducts(1, 'C')));
        return "search";
    }

    @GetMapping("/allProductsAves")
    public String showAllAves(Model model) {
        model.addAttribute("isDestacados", false);
        model.addAttribute("path", "/resource/btnfiltroave.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Todos los productos de aves");
        model.addAttribute("products", convertToDTO(shop.getPetProducts(1, 'B')));
        return "search";
    }
    @GetMapping("/allProductsPeces")
    public String showAllPeces(Model model) {
        model.addAttribute("isDestacados", false);
        model.addAttribute("path", "/resource/btnfiltropez.png");
        model.addAttribute("textSearch", new Message());
        model.addAttribute("title", "Todos los productos de peces");
        model.addAttribute("products", convertToDTO(shop.getPetProducts(1, 'F')));
        return "search";
    }

    public List<ProductDto> convertToDTO(List<Product> products) {
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            if (product != null) {
                String typePet = product.getTypePet() == 'D' ? "Perro"
                        : product.getTypePet() == 'C' ? "Gato" : product.getTypePet() == 'B' ? "Ave" : "Pez";
                DecimalFormat formato = new DecimalFormat("#,###");
                String priceFormat = formato.format(product.getPrice());
                String priceDesFormat = formato.format(product.getPriceDes());
                productDtos.add(new ProductDto(product.getIdProduct(), product.getUrlimg(), product.getName(),
                        product.getDescription(), typePet, product.getWeigth(), priceFormat, priceDesFormat,
                        product.getQuantyStock(), product.getMark().getName()));
            }
        }
        return productDtos;
    }

}
