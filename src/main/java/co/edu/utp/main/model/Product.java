package co.edu.utp.main.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Product {
    private int idProduct;
    private String urlimg;
    private String name;
    private String description;
    private char typePet;
    private String weigth;
    private float price;
    private float priceDes;
    private int quantyStock;
    private Mark mark;

    

    public Product(int idProduct, String urlimg, String name, String description, char typePet, String weigth,
            float price, float priceDes, int quantyStock, Mark mark) {
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrlimg() {
        return urlimg;
    }
    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public char getTypePet() {
        return typePet;
    }
    public void setTypePet(char typePet) {
        this.typePet = typePet;
    }
    public String getWeigth() {
        return weigth;
    }
    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPriceDes() {
        return priceDes;
    }
    public void setPriceDes(float priceDes) {
        this.priceDes = priceDes;
    }
    public int getQuantyStock() {
        return quantyStock;
    }
    public void setQuantyStock(int quantyStock) {
        this.quantyStock = quantyStock;
    }
    public Mark getMark() {
        return mark;
    }
    public void setMark(Mark mark) {
        this.mark = mark;
    }

    
}
