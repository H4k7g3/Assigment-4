package com.company.entities;

import java.sql.Date;

public class Med {
    private int id;
    private String name;
    private int price;
    private Date expiration;
    private String manufacturer;
    private boolean byrecept;

    public Med() {

    }

    public Med(String name, int price, Date expiration , String manufacturer ,boolean byrecept) {
        setName(name);
        setPrice(price);
        setExpiration(expiration);
        setManufacturer(manufacturer);
        setByRecept(byrecept);
    }

    public Med(int id,String name, int price, Date expiration , String manufacturer ,boolean byrecept ) {
        setId(id);
        setName(name);
        setPrice(price);
        setExpiration(expiration);
        setManufacturer(manufacturer);
        setByRecept(byrecept);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setByRecept(boolean byrecept) {
        this.byrecept = byrecept;
    }

    public boolean getByRecept() {
        return byrecept;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", expiration='" + expiration + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", byrecept=" + byrecept + '\''+
                '}';
    }
}