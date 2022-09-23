package co.edu.utp.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int idProduct;
    private String urlimg;
    private String name;
    private String description;
    private char typePet;
    private String weigth;
    private float price;
    private int quantyStock;
    private Mark mark;
}
