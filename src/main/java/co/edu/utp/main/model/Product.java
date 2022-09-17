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
    private String typePet;
    private String weigth;
    private String price;
    private int quantyStock;
    private String mark;
}
