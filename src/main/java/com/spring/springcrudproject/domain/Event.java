package com.spring.springcrudproject.domain;

//это класс будет иммитировать строку в таблице баззы данных:
public class Event {
    private String name;
    private String city;
    private double price;

    public Event(String name, String city, double price) {
        this.name = name;
        this.city = city;
        this.price = price;
    }

    public Event(){}

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public double getPrice() { return price; }

    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPrice(double price) { this.price = price;}
}
