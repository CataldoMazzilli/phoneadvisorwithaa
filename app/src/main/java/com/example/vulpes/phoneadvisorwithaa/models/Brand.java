package com.example.vulpes.phoneadvisorwithaa.models;

import java.util.ArrayList;

/**
 * Created by vulpes on 01/12/14.
 */
public class Brand {

    static int counter = 0;
    private int id;
    private String name;
    private int img;
    private ArrayList<Phone> mPhoneList;

    public Brand(String name, int img, ArrayList<Phone> phoneList) {
        this.id = counter;
        counter++;
        this.name = name;
        this.img = img;
        this.mPhoneList = phoneList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public ArrayList<Phone> getmPhoneList() {
        return mPhoneList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }
}