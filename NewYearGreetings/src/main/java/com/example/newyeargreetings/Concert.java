package com.example.newyeargreetings;

import java.io.FileReader;
import java.util.Scanner;

public class Concert {
    private String nameOfGift;
    private int priceOfGift;

    public Concert(String nameOfGift, int priceOfGift) {
        this.nameOfGift = nameOfGift;
        this.priceOfGift = priceOfGift;
    }

    public Concert() {
        nameOfGift = null;
        priceOfGift = 0;
    }

    public String getNameOfGift() {
        return nameOfGift;
    }

    public void setNameOfGift(String nameOfGift) {
        this.nameOfGift = nameOfGift;
    }

    public int getPriceOfGift() {
        return priceOfGift;
    }

    public void setPriceOfGift(int priceOfGift) {
        this.priceOfGift = priceOfGift;
    }

    public void GiftReader() throws Exception {
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
    }

}
