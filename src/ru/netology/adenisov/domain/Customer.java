package ru.netology.adenisov.domain;

public class Customer {
    int id;
    String name;

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name=" + "'" + name + "'" + "}";
    }
}
