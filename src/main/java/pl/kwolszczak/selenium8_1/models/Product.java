package pl.kwolszczak.selenium8_1.models;

import pl.kwolszczak.selenium8_1.models.ext.ProductDetails;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private String size;
    private String color;
    private String description;
    private ProductDetails details;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return (this.name+this.price).compareTo(o.name+o.price);
    }
}
