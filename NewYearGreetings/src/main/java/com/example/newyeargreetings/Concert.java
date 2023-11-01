package com.example.newyeargreetings;

import java.io.FileReader;
import java.util.Scanner;

public class Concert {
    private String nameOfConcert;
    private int priceOfConcert;

    public Concert(String nameOfConcert, int priceOfConcert) {
        this.nameOfConcert = nameOfConcert;
        this.priceOfConcert = priceOfConcert;
    }

    public Concert() {
        nameOfConcert = null;
        priceOfConcert = 0;
    }

    public String getNameOfConcert() {
        return nameOfConcert;
    }

    public void setNameOfConcert(String nameOfConcert) {
        this.nameOfConcert = nameOfConcert;
    }

    public int getPriceOfConcert() {
        return priceOfConcert;
    }

    public void setPriceOfConcert(int priceOfConcert) {
        this.priceOfConcert = priceOfConcert;
    }

    public void concertReader(Scanner in, FileReader fr) throws Exception {
        String str = in.nextLine();
        String[] words = str.split(" ");
        setNameOfConcert(words[0]);
        setPriceOfConcert(Integer.parseInt(words[1]));
    }

}
