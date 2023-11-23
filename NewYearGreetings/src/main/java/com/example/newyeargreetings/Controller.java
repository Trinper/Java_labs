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


    private Model model = new Model();

    private final ObservableList<String> langs = FXCollections.observableArrayList();
    private final ObservableList<String> langsConcerts = FXCollections.observableArrayList();
    private final ObservableList<String> langsGifts = FXCollections.observableArrayList();

    public void setModel(Model model){
        this.model = model;
    }
    @FXML
    private CheckBox regularCustomer = new CheckBox();

    @FXML
    private Label costConcert = new Label();

    @FXML
    private Label costGift = new Label();

    @FXML
    private Label cost = new Label();

    @FXML
    private ComboBox<String> manufacturersBox = new ComboBox<>();

    @FXML
    private ComboBox<String> concertsBox = new ComboBox<>();
    @FXML
    private ComboBox<String> giftsBox = new ComboBox<>();

    private String selectedManufacturer = null;
    private String selectedConcert = null;
    private String selectedGift = null;
    private int costOfSelectedConcert;
    private int costOfSelectedGift;
    private boolean regular;
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

        concertsBox.setOnAction((event) ->{
            selectedConcert = concertsBox.getSelectionModel().getSelectedItem();
            if (!Objects.equals(selectedConcert, "Select Concert") && selectedConcert != null) {
                getCostOfConcert();
                costConcert.setText("Selected concert: " + selectedConcert + '\n' + "Price of concert: " + costOfSelectedConcert);
                regular = regularCustomer.isSelected();
                updateCost();
            }
        });

        giftsBox.setOnAction((event) ->{
            selectedGift = giftsBox.getSelectionModel().getSelectedItem();
            if (!Objects.equals(selectedGift, "Select Gift") && selectedGift != null) {
                getCostOfGift();
                costGift.setText("Selected gift: " + selectedGift + '\n' + "Price of gift: " + costOfSelectedGift);
                regular = regularCustomer.isSelected();
                updateCost();
            }
        });
    }

    public void updateCost(){
        double finalCost = (regular ? (costOfSelectedConcert + costOfSelectedGift) * 0.9: costOfSelectedConcert + costOfSelectedGift);
        cost.setText("Final cost: " + finalCost);
    }

    public void getCostOfConcert() {
        for (var manufacturer : model.manufacturers) {
            if (Objects.equals(manufacturer.getNameOfManufacturer(), selectedManufacturer)) {
                for (var concert : manufacturer.getConcerts()) {
                    if (Objects.equals(concert.getNameOfConcert(),selectedConcert)){
                        costOfSelectedConcert = concert.getPriceOfConcert();
                    }
                }
            }
        }
    }

    public void getCostOfGift() {
        for (var manufacturer : model.manufacturers) {
            if (Objects.equals(manufacturer.getNameOfManufacturer(), selectedManufacturer)) {
                for (var gift : manufacturer.getGifts()) {
                    if (Objects.equals(gift.getNameOfGift(),selectedGift)){
                        costOfSelectedGift = gift.getPriceOfGift();
                    }
                }
            }
        }
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