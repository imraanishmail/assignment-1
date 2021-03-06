package com.ishmail.model;

public class Game {

    // Class variables
    private String name;
    private double price;
    private int quantity;
    private Developer developer;

    // Enumerator
    public enum Developer {
        CAPCOM, FROMSOFTWARE, SEGA
    }

    // Parameterized constructor
    public Game(String name, double price, int quantity, Developer developer) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.developer = developer;
    }

    // Accessors and  Mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    // toString method to return the name of the games
    public String toString() {
        return name;
    }
}
