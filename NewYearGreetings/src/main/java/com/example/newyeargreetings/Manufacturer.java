package com.example.newyeargreetings;

import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Manufacturer {
    private String nameOfManufacturer;
    private Vector<Gift> gifts;
    private Vector<Concert> concerts;

    public Manufacturer(){
        this.nameOfManufacturer = null;
        this.concerts = new Vector<>();
        this.gifts = new Vector<>();
    }

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

    public void manufacturerReader(Scanner in, FileReader fr) throws Exception{
        setNameOfManufacturer(in.nextLine());
        int numOfGifts = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numOfGifts; i++){
            Gift gift = new Gift();
            gift.giftReader(in, fr);
            addNewGift(gift);
        }
        int numOfConcerts = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numOfConcerts; i++){
            Concert concert = new Concert();
            concert.concertReader(in, fr);
            addNewConcert(concert);
        }
    }
}
