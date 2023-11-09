package com.example.newyeargreetings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.BufferUnderflowException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Controller {

    //private boolean start = true;
    private Model model;

    public void setModel(Model model){
        this.model = model;
    }

    @FXML
    private FlowPane root;
    @FXML
    private FlowPane rootConcert = new FlowPane(Orientation.VERTICAL);

    private final ToggleGroup group = new ToggleGroup();

    public Controller() throws Exception {
        model = new Model();
        root = new FlowPane();
        root.setPadding(new Insets(10));
        addManufacturers();
        /*RadioButton selection = (RadioButton) group.getSelectedToggle();
        for (Manufacturer manufacturer: model.manufacturers){
            if (Objects.equals(manufacturer.getNameOfManufacturer(), selection.getText())){
                addConcerts(manufacturer);
            }
        }*/
    }

    @FXML
    public void addManufacturers() throws Exception{
        for (Manufacturer manufacturer : model.manufacturers) {
            System.out.println(1);
            RadioButton btn = new RadioButton(manufacturer.getNameOfManufacturer());
            btn.setToggleGroup(group);
            root.getChildren().add(btn);
        }

    }

    @FXML
    public void addConcerts(Manufacturer manufacturer) throws Exception{
        Vector <Concert> concerts = manufacturer.getConcerts();
        for (Concert concert : concerts) {
            CheckBox checkBox = new CheckBox(concert.getNameOfConcert());
            rootConcert.getChildren().add(checkBox);
        }
        rootConcert.setPadding(new Insets(10));
    }
}