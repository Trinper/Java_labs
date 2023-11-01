package com.example.newyeargreetings;

import java.util.Vector;

public class Manufacturer {
    private String nameOfManufacturer;
    private Vector<Gift> gifts;
    private Vector<Concert> concerts;

    public Manufacturer(String nameOfManufacturer, Vector<Gift> gifts, Vector<Concert> concerts) {
        this.nameOfManufacturer = nameOfManufacturer;
        this.gifts = gifts;
        this.concerts = concerts;
    }

    public Manufacturer(String nameOfManufacturer) {
        this.nameOfManufacturer = nameOfManufacturer;
        this.gifts = new Vector<>();
        this.concerts = new Vector<>();
    }

    public String getNameOfManufacturer() {
        return nameOfManufacturer;
    }

    public void setNameOfManufacturer(String nameOfManufacturer) {
        this.nameOfManufacturer = nameOfManufacturer;
    }

    public void addNewGift(Gift gift){
        this.gifts.add(gift);
    }

    public void addNewConcert(Concert concert){
        this.concerts.add(concert);
    }
}
