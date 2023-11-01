package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private long num1 = 0;
    private long num2 = 0;

    private Model model = new Model();
    private  boolean start = true;
    private String operator = "";

    @FXML
    private Text text;

    @FXML
    private void processNum(ActionEvent event){
        if (start){
            text.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        text.setText(text.getText() + value);

    }

    @FXML
    private void processOperation(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!"=".equals(value)){
            if (!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(text.getText());
            text.setText("");
        } else {
            if (operator.isEmpty()) return;
            text.setText(String.valueOf(model.calculation(num1, Long.parseLong(text.getText()), operator)));
            operator = "";
            start = true;
        }
    }
}