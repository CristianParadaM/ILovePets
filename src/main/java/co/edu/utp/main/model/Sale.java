package co.edu.utp.main.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sale {

    private int id;
    private ArrayList<Integer> products;
    private LocalDateTime date;
    private EnumTypeToPay enumTypeToPay;
    private float subtotal;
    private float taxes;
    private float total;
    private int idClient;

}
