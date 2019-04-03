package model;

public class EngineerStudent extends Student {

    public EngineerStudent(int id, int stNumber, String name, String surname) {
        this.id = id;
        this.stNumber = stNumber;
        this.name = name;
        this.surname = surname;

        this.type = "Electronics";
    }
    



    public String toString() {
        return id +
                ":"+
                "Engineer{" +
                "stNumber=" + stNumber +
                ", name='" + name + '\'' +
                ", surname=" + surname +

                ", type='" + type + '\'' +
                '}';
    }
}
