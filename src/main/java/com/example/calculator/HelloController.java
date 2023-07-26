package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField text_space;

    @FXML
    void onZeroButtonClick() {
        text_space.appendText("0");
    }

    @FXML
    void onOneButtonClick() {
        text_space.appendText("1");
    }

    @FXML
    void onTwoButtonClick() {
        text_space.appendText("2");
    }

    @FXML
    void onThreeButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onFourButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onFiveButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onSixButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onSevenButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onEightButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onNineButtonClick() {
        text_space.appendText("3");
    }

    @FXML
    void onACButtonClick() {
        text_space.setText(null);
    }

    @FXML
    void onSubtractButtonClick() {
        text_space.appendText(" - ");
    }

    @FXML
    void onAddButtonClick() {
        text_space.appendText(" + ");
    }

    @FXML
    void onMultiplyButtonClick() {
        text_space.appendText(" * ");
    }

    @FXML
    void onDivideButtonClick() {
        text_space.appendText(" / ");
    }

    @FXML
    void onEqualsButtonClick() {

    }
}
/* TO DO
       make calculator work (basic functions first)
       display full equation?
       add comments describing what things do
       swag
 */