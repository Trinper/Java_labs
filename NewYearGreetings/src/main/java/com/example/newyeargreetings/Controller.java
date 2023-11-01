package com.example.newyeargreetings;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.Vector;

public class Controller {

    private Model model = new Model();
    @FXML
    private FlowPane root;
    private Vector <Manufacturer> manufacturers;

    public void Reader() throws Exception{
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        int numOfManufacturer;
        numOfManufacturer = Integer.parseInt(in.nextLine());
        System.out.println(1);
        Vector <Manufacturer> manufacturers = new Vector<>(numOfManufacturer);
        for (int i = 0; i < numOfManufacturer; i++){
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.manufacturerReader(in, fr);
        }
    }
    @FXML
    public void addManufacturers() throws Exception {
        Reader();
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < manufacturers.size(); i++){
            RadioButton btn = new RadioButton(manufacturers.get(i).getNameOfManufacturer());
            btn.setToggleGroup(group);
            root.getChildren().add(btn);
        }
        root.setPadding(new Insets(10));
    }

}