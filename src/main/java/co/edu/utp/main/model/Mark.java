package co.edu.utp.main.model;

public class Mark {

    private int idMark;
    private String name;

    public Mark(int idMark, String name) {
        this.idMark = idMark;
        this.name = name;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
