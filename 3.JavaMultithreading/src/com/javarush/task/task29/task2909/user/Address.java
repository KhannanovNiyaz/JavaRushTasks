package com.javarush.task.task29.task2909.user;

public class Address {
    private String house;
    private String country;
    private String city;

    public void setHouse(String house) {
        this.house = house;
    }

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

}