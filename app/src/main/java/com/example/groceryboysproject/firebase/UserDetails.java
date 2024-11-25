package com.example.groceryboysproject.firebase;

import java.util.List;

public class UserDetails {
    private String name;
    private String email;
    private double moneySpent;
    private List<Item> items;

    // Constructor
    public UserDetails(String name, String email, double moneySpent, List<Item> items) {
        this.name = name;
        this.email = email;
        this.moneySpent = moneySpent;
        this.items = items;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getMoneySpent() { return moneySpent; }
    public void setMoneySpent(double moneySpent) { this.moneySpent = moneySpent; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    // Nested class for items
    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
    }
}
