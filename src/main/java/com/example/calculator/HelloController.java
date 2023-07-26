package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private TextField text_space;

    @FXML
    private TextField fullEquation;

    @FXML
    private String firstNum = "";

    @FXML
    private String currentNum = "";

    @FXML
    private String calcOperation;

    @FXML
    void onZeroButtonClick() {
        fullEquation.appendText("0");
    }

    @FXML
    void onOneButtonClick() {
        setDigit("1");
    }

    @FXML
    void onTwoButtonClick() {
        setDigit("2");
    }

    @FXML
    void onThreeButtonClick() {
        setDigit("3");
    }

    @FXML
    void onFourButtonClick() {
        setDigit("4");
    }

    @FXML
    void onFiveButtonClick() {
        setDigit("5");
    }

    @FXML
    void onSixButtonClick() {
        setDigit("6");
    }

    @FXML
    void onSevenButtonClick() {
        setDigit("7");
    }

    @FXML
    void onEightButtonClick() {
        setDigit("8");
    }

    @FXML
    void onNineButtonClick() {
        setDigit("9");
    }

    @FXML
    void onACButtonClick() {
        text_space.setText(null);
        fullEquation.setText(null);
        currentNum = "";
        firstNum = "";
    }

    @FXML
    void onSubtractButtonClick() {
        fullEquation.appendText(" - ");
        prepareCalc("-");
    }

    @FXML
    void onAddButtonClick() {
        fullEquation.appendText(" + ");
        prepareCalc("+");
    }

    @FXML
    void onMultiplyButtonClick() {
        fullEquation.appendText(" * ");
        prepareCalc("*");
    }

    @FXML
    void onDivideButtonClick() {
        fullEquation.appendText(" / ");
        prepareCalc("/");
    }

    @FXML
    void onEqualsButtonClick() {
        fullEquation.appendText(" = ");
        calculate();
    }

    @FXML
    public void setDigit(String num){
        currentNum += num;
        fullEquation.appendText(currentNum);
        text_space.setText(currentNum);
    }

    @FXML
    public void prepareCalc(String calcOperation){
        this.calcOperation = calcOperation;
        firstNum = currentNum;
        currentNum = "";
    }
    @FXML
    void calculate(){

        double firstNumDouble = Double.parseDouble(firstNum);
        double secondNumDouble = Double.parseDouble(currentNum);
        double finalNum;

        switch (calcOperation) {
            case "-" : //subtraction case
                    finalNum = firstNumDouble - secondNumDouble;
                    String result = String.format("%.2f", finalNum);
                    fullEquation.appendText(result);
                    text_space.setText(result);

            case "+" : //addition case

                    finalNum = firstNumDouble + secondNumDouble;
                    fullEquation.appendText(String.valueOf(finalNum));
                    text_space.setText(String.valueOf(finalNum));

            case "*" : //multiplication case

                    finalNum = firstNumDouble * secondNumDouble;
                    fullEquation.appendText(String.valueOf(finalNum));
                    text_space.setText(String.valueOf(finalNum));

            case "/" : //division case

                    finalNum = firstNumDouble / secondNumDouble;
                    fullEquation.appendText(String.valueOf(finalNum));
                    text_space.setText(String.valueOf(finalNum));
        }
    }


}
/* TO DO
       make calculator work (basic functions first)
       display full equation?
       add comments describing what things do
       swag
 */