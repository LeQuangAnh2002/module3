package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    private String name;
    private Date birthDate;
    private String address;
    private  String image;

    private static  final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public Customer() {
    }

    public Customer(String name, String birthDatetr, String address, String image) {
        this.name = name;

        this.address = address;
        this.image = image;
        try{
            this.birthDate = df.parse(birthDatetr);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
