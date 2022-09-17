package co.edu.utp.main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.utp.main.model.Product;

@Controller
public class ILovePetsController {

    @GetMapping("/admin")
    public String goToAdmin() {
        return "admin";
    }

    @GetMapping("/catalog")
    public String goToindex(Model model){

        List<Product> productsDestacados = Arrays.asList(
            new Product(1, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix"),
            new Product(2,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky"),
            new Product(3,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross"),
            new Product(4,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir"),
            new Product(5,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky")
            );
            
        List<Product> productsPerros = Arrays.asList(
            new Product(6,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky"),
            new Product(7,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky"),
            new Product(8,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky"),
            new Product(9,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky"),
            new Product(10,"resource/chunky.jpg", "Purina Chunky", "desc", "d", "1.5gr", "10,500", 200, "Chunky")
        );
        List<Product> productsGatos = Arrays.asList(
            new Product(11, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix"),
            new Product(12, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix"),
            new Product(13, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix"),
            new Product(14, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix"),
            new Product(15, "resource/cardimg.png","Purina Felix", "descripcion jaja", "c", "85gr", "10,500", 200, "Felix")
        );

        List<Product> productsAves = Arrays.asList(
            new Product(16,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir"),
            new Product(17,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir"),
            new Product(18,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir"),
            new Product(19,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir"),
            new Product(20,"resource/vivir.jpg", "Alimento Aves", "desc", "b", "1.5gr", "10,500", 200, "Vivir")
        );
        List<Product> productsPeces = Arrays.asList(
            new Product(21,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross"),
            new Product(22,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross"),
            new Product(23,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross"),
            new Product(24,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross"),
            new Product(25,"resource/incross.jpg", "Alimento Peces", "desc", "f", "1.5gr", "10,500", 200, "Incross")
        );

        model.addAttribute("productsDestacados", productsDestacados);
        model.addAttribute("productsPerros", productsPerros);
        model.addAttribute("productsGatos", productsGatos);
        model.addAttribute("productsAves", productsAves);
        model.addAttribute("productsPeces", productsPeces);
        return "index";
    }

}
