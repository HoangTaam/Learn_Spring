package com.TamUIT.Learn_Spring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    //primary key
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String productName;
    private double price;
    private int year;
    private String url;
    //default constructor
    public Product() {
    }

    public Product(String productName, double price, int year, String url) {
        this.productName = productName;
        this.price = price;
        this.year = year;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", url='" + url + '\'' +
                '}';
    }
}
