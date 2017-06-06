package com.daily.programmer.sydney.tour;

public class Tour {

    private String id;

    private String name;

    private Double price;

    public Tour(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Tour(Tour tour) {
        this.id = tour.getId();
        this.name = tour.getName();
        this.price = tour.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
