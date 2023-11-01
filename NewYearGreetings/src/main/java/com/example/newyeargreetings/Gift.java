package com.example.newyeargreetings;

import java.io.FileReader;
import java.util.Scanner;

public class Gift {
    private String nameOfGift;
    private int priceOfGift;

    Gift(){
        nameOfGift = null;
        priceOfGift = 0;
    }

    Gift(String _nameOfGift, int _priceOfGift){
        nameOfGift = _nameOfGift;
        priceOfGift = _priceOfGift;
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
