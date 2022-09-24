package co.edu.utp.main.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Client {
    private int id;
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private String address;
}
