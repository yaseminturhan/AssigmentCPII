package model;

public class MedicalStudent extends Student {

    public MedicalStudent(int id, int stNumber, String name, String surname) {
    	   this.id = id;
           this.stNumber = stNumber;
           this.name = name;
           this.surname = surname;
           this.type = "Electronics";
       }
    

    public String toString() {
        return id +
                ":"+
                "Electronic{" +
                "stNumber=" + stNumber +
                ", name='" + name + '\'' +
                ", surname=" + surname +
                ", type='" + type + '\'' +
                '}';
    }
}
