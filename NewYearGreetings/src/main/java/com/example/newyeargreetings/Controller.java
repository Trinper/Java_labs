package com.example.newyeargreetings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.Vector;

public class Controller {

    //private boolean start = true;
    private Model model = new Model();
    private ObservableList<String> langs = FXCollections.observableArrayList();
    private ObservableList<String> langsConcerts = FXCollections.observableArrayList();
    private ObservableList<String> langsGifts = FXCollections.observableArrayList();

    public void setModel(Model model){
        this.model = model;
    }

    @FXML
    private ComboBox<String> manufacturersBox = new ComboBox<>();

    @FXML
    private ComboBox<String> concertsBox = new ComboBox<>();
    @FXML
    private ComboBox<String> giftsBox = new ComboBox<>();

    private String selectedManufacturer = null;

    public Controller() throws Exception {
    }

    @FXML
    private void initialize() throws Exception {
        addManufacturers();
       manufacturersBox.setOnAction((event) -> {
           selectedManufacturer = manufacturersBox.getSelectionModel().getSelectedItem();
           try {
               addConcerts();
               addGifts();
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       });
    }

    @FXML
   public void addManufacturers() throws Exception{

        for (Manufacturer manufacturer : model.manufacturers) {
            langs.add(manufacturer.getNameOfManufacturer());
        }
        manufacturersBox.setValue("Select Manufacturer");
        manufacturersBox.setItems(langs);
    }

    @FXML
    public void addConcerts() throws Exception{
        langsConcerts.clear();
        Manufacturer manufacturer = new Manufacturer();
        for (var manufacturer_ : model.manufacturers){
            if (Objects.equals(manufacturer_.getNameOfManufacturer(), selectedManufacturer)){
                manufacturer = manufacturer_;
            }
        }
        Vector <Concert> concerts = manufacturer.getConcerts();
        for (Concert concert : concerts) {
            langsConcerts.add(concert.getNameOfConcert());
        }
        concertsBox.setValue("Select Concert");
        concertsBox.setItems(langsConcerts);
    }

    @FXML
    public void addGifts() throws Exception{
        langsGifts.clear();
        Manufacturer manufacturer = new Manufacturer();
        for (var manufacturer_ : model.manufacturers){
            if (Objects.equals(manufacturer_.getNameOfManufacturer(), selectedManufacturer)){
                manufacturer = manufacturer_;
            }
        }
        Vector <Gift> gifts = manufacturer.getGifts();
        for (Gift gift : gifts) {
            langsGifts.add(gift.getNameOfGift());
        }
        giftsBox.setValue("Select Gift");
        giftsBox.setItems(langsGifts);
    }
}