package com.spring.springcrudproject.domain;

//это класс будет иммитировать строку в таблице баззы данных:
public class Event {
    private String name;
    private String city;

    public Event(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
