package com.example.Product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name missing")
    private String name;

    private String description;

    @NotBlank
    private String thumbnail_url;

    @Min(message = "Adults can not be less than 1", value = 1)
    private int adults;

    @Min(message = "Children can not be negative", value = 0)
    private int children;

    @Min(message = "Price can not be negative", value = 0)
    private double price;
    private String extraInformation;

    public Product() {

    }

    public Product(String name, String description, String thumbnail_url, int adults, int children, double price, String extraInformation) {
        this.name = name;
        this.description = description;
        this.thumbnail_url = thumbnail_url;
        this.adults = adults;
        this.children = children;
        this.price = price;
        this.extraInformation = extraInformation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }
}