package co.edu.utp.main.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale {

    private int id;
    private ArrayList<Integer> products;
    private LocalDateTime date;
    private EnumTypeToPay enumTypeToPay;
    private float subtotal;
    private float taxes;
    private float total;
    private int idClient;
    
    public Sale(int id, ArrayList<Integer> products, LocalDateTime date, EnumTypeToPay enumTypeToPay, float subtotal,
            float taxes, float total, int idClient) {
        this.id = id;
        this.products = products;
        this.date = date;
        this.enumTypeToPay = enumTypeToPay;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.total = total;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Integer> products) {
        this.products = products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public EnumTypeToPay getEnumTypeToPay() {
        return enumTypeToPay;
    }

    public void setEnumTypeToPay(EnumTypeToPay enumTypeToPay) {
        this.enumTypeToPay = enumTypeToPay;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    

    
}
