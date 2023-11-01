package com.example.newyeargreetings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.BindException;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("greetings.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1020, 480);
        stage.setTitle("NewYearGreetings");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);

        launch();
    }
}