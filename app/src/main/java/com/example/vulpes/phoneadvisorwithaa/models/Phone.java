package com.example.vulpes.phoneadvisorwithaa.models;

/**
 * Created by vulpes on 01/12/14.
 */
public class Phone {

    static int counter = 0;
    private int id;
    private String brandName;
    private int img;
    private String name;

    public Phone(String brandName, int img, String name) {
        this.id = counter;
        counter++;
        this.brandName = brandName;
        this.img = img;
        this.name = name;
    }

    public String getBrand() {
        return brandName;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setBrand(String brandName) {
        this.brandName = brandName;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }
}