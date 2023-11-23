package com.example.newyeargreetings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("greetings.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 480);
        stage.setTitle("NewYearGreetings");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}