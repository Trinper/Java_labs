package com.example.newyeargreetings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Model {
    public Vector <Manufacturer> manufacturers = new Vector<>();

    public Model() throws Exception {
        /*FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfManufacturer;
        numOfManufacturer = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numOfManufacturer; i++){
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.manufacturerReader(in, fr);
            manufacturers.add(manufacturer);
        }*/
        try {
            String url = "jdbc:mysql://localhost/manufacturers?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from manufacturer");
            Vector <String> manufacturersNames = new Vector<>();
            while (resultSet.next()){
                String manufacturerName = resultSet.getString(1);
                if (!manufacturersNames.contains(manufacturerName)){
                    manufacturersNames.add(manufacturerName);
                    Manufacturer manufacturer = new Manufacturer();
                    manufacturer.setNameOfManufacturer(manufacturerName);
                    manufacturers.add(manufacturer);
                }
                if (resultSet.getString(2) != null){
                    for (var manufacturer: manufacturers){
                        if (Objects.equals(manufacturer.getNameOfManufacturer(), manufacturerName)){
                            manufacturer.addNewGift(new Gift(resultSet.getString(2) , resultSet.getInt(3) ));
                        }
                    }
                } else {
                    for (var manufacturer: manufacturers){
                        if (Objects.equals(manufacturer.getNameOfManufacturer(), manufacturerName)){
                            manufacturer.addNewConcert(new Concert(resultSet.getString(4) , resultSet.getInt(5)));
                        }
                    }
                }
            }
        }
        catch (Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
