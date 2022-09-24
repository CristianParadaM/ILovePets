package co.edu.utp.main.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int idProduct;
    private String urlimg;
    private String name;
    private String description;
    private String typePet;
    private String weigth;
    private String price;
    private String priceDes;
    private int quantyStock;
    private String mark;

}
