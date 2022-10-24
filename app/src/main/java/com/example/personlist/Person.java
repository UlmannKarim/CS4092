package com.example.personlist;

import java.io.Serializable;

public class Person {
    public Person(String name, String phone, String address, String image, String url) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.url = url;
    }

    private String name, phone, address, image, url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
