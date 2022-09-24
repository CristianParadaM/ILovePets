package co.edu.utp.main.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sale {

    private int id;
    private List<Integer> products;
    private LocalDateTime date;
    private EnumTypeToPay enumTypeToPay;
    private int idClient;

}
