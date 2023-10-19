package com.edu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Cloneable {
    // Attributes
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String image;

    // Constructors
    public Products() {

    }

    public Products(int id, String name, double price, int quantity,
            String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    // Method
    public Products orderProduct(int quantity) {
        Products prod = null;
        if (quantity <= this.quantity) {
            try {
                prod = (Products) this.clone();
                prod.setQuantity(quantity);
                this.quantity -= quantity;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return prod;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
