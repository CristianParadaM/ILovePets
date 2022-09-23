package co.edu.utp.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.utp.main.controller.dto.ProductDto;

@Controller
public class ILovePetsController {

    @GetMapping("/admin")
    public String goToAdmin() {
        return "admin";
    }

    @GetMapping("/catalog")
    public String goToCatalog(Model model){

        String descgatos = "Descripción:\n\nLos Gatos más divertidos necesitan recargar energía con Purina® Felix®. ¡Dale una vida más sana a tu gato con los mejores sabores ¡Conoce más aquí. Felix Classics.Felix Fantastic.";
        String descperros = "Descripción:\n\nLos Gatos más divertidos necesitan recargar energía con Purina® Felix®. ¡Dale una vida más sana a tu gato con los mejores sabores ¡Conoce más aquí. Felix Classics. Felix Fantastic.";
        String descpeces = "Descripción:\n\nLos Gatos más divertidos necesitan recargar energía con Purina® Felix®. ¡Dale una vida más sana a tu gato con los mejores sabores ¡Conoce más aquí. Felix Classics. Felix Fantastic.";
        String descaves = "Descripción:\n\nLos Gatos más divertidos necesitan recargar energía con Purina® Felix®. ¡Dale una vida más sana a tu gato con los mejores sabores ¡Conoce más aquí. Felix Classics. Felix Fantastic.";
        

        List<ProductDto> productsDestacados = Arrays.asList(
            new ProductDto(1, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix"),
            new ProductDto(2,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky"),
            new ProductDto(3,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross"),
            new ProductDto(4,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir"),
            new ProductDto(5,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky")
            );
            
        List<ProductDto> productsPerros = Arrays.asList(
            new ProductDto(6,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky"),
            new ProductDto(7,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky"),
            new ProductDto(8,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky"),
            new ProductDto(9,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky"),
            new ProductDto(10,"resource/chunky.jpg", "Purina Chunky", descperros, "perro", "1.5gr", "10,500", 200, "Chunky")
        );
        List<ProductDto> productsGatos = Arrays.asList(
            new ProductDto(11, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix"),
            new ProductDto(12, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix"),
            new ProductDto(13, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix"),
            new ProductDto(14, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix"),
            new ProductDto(15, "resource/cardimg.png","Purina Felix", descgatos, "gato", "85gr", "10,500", 200, "Felix")
        );

        List<ProductDto> productsAves = Arrays.asList(
            new ProductDto(16,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir"),
            new ProductDto(17,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir"),
            new ProductDto(18,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir"),
            new ProductDto(19,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir"),
            new ProductDto(20,"resource/vivir.jpg", "Alimento Aves", descaves, "ave", "1.5gr", "10,500", 200, "Vivir")
        );
        List<ProductDto> productsPeces = Arrays.asList(
            new ProductDto(21,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross"),
            new ProductDto(22,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross"),
            new ProductDto(23,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross"),
            new ProductDto(24,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross"),
            new ProductDto(25,"resource/incross.jpg", "Alimento Peces", descpeces, "pez", "1.5gr", "10,500", 200, "Incross")
        );

        model.addAttribute("productsDestacados", productsDestacados);
        model.addAttribute("productsPerros", productsPerros);
        model.addAttribute("productsGatos", productsGatos);
        model.addAttribute("productsAves", productsAves);
        model.addAttribute("productsPeces", productsPeces);
        return "index";
    }

    @GetMapping("/")
    public String goToindex(Model model){
        return goToCatalog(model);
    }

}
