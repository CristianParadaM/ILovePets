package co.edu.utp.main.model;

import java.util.Arrays;
import java.util.List;

public class Shop {

    private List<Product> products;
    private List<Integer> featuredProducts;

    public Shop() {
        products = Arrays.asList(
                new Product(1, "", "Chunky", "Hola", 'D', "1.5Kg", 12500f, 20, new Mark(10001, "Chunky")),
                new Product(2, "", "Chunky", "Hola", 'D', "1.5Kg", 12500f, 20, new Mark(10001, "Chunky")),
                new Product(3, "", "Chunky", "Hola", 'D', "1.5Kg", 12500f, 20, new Mark(10001, "Chunky")),
                new Product(4, "", "Chunky", "Hola", 'D', "1.5Kg", 12500f, 20, new Mark(10001, "Chunky")));
    }


}
