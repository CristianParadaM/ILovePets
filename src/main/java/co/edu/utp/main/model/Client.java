package co.edu.utp.main.model;

import java.time.LocalDate;

public class Client {
    private int id;
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private String address;

    public Client(int id, String name, String lastname, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
