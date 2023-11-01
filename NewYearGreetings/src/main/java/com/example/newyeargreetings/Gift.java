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

    public void giftReader(Scanner in, FileReader fr) throws Exception {
        String str = in.nextLine();
        String[] words = str.split(" ");
        setNameOfGift(words[0]);
        setPriceOfGift(Integer.parseInt(words[1]));
    }
}
