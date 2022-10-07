package co.edu.utp.main.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public ProductDto(int idProduct, String urlimg, String name, String description, String typePet, String weigth,
            String price, String priceDes, int quantyStock, String mark) {
        this.idProduct = idProduct;
        this.urlimg = urlimg;
        this.name = name;
        this.description = description;
        this.typePet = typePet;
        this.weigth = weigth;
        this.price = price;
        this.priceDes = priceDes;
        this.quantyStock = quantyStock;
        this.mark = mark;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceDes() {
        return priceDes;
    }

    public void setPriceDes(String priceDes) {
        this.priceDes = priceDes;
    }

    public int getQuantyStock() {
        return quantyStock;
    }

    public void setQuantyStock(int quantyStock) {
        this.quantyStock = quantyStock;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
