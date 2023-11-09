package com.example.newyeargreetings;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Model {
    public Vector <Manufacturer> manufacturers = new Vector<>();

    public Model() throws Exception {
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfManufacturer;
        numOfManufacturer = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numOfManufacturer; i++){
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.manufacturerReader(in, fr);
            manufacturers.add(manufacturer);
        }
    }
}
