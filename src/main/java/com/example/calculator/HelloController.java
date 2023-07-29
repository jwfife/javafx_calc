package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Objects;


public class HelloController {
    @FXML
    private TextField text_space;

    @FXML
    private TextField fullEquation;

    @FXML
    private String firstNum = "";

    @FXML
    private String currentNum = "0";

    @FXML
    private String calcOperation;

    @FXML
    void onZeroButtonClick() {
        double currentNumValue = Double.parseDouble(currentNum);
        if ((!Objects.equals(currentNum, "")) && (currentNumValue != 0)){
            setDigit("0");
        }
        else {
            if (fullEquation.getLength() == 1) {
                fullEquation.setText("0");
                text_space.setText("0");
            }
            else {
                fullEquation.appendText("0");
                text_space.setText("0");
            }
        }
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
        fullEquation.setText("");
        text_space.setText("0");
        currentNum = "0";
        firstNum = "";
    }
    @FXML
    void onNegativeButtonClick() {
        double negNum = Double.parseDouble(currentNum);
        negNum *= -1;
        currentNum = String.valueOf(negNum);
        text_space.setText(String.valueOf(negNum));
        fullEquation.setText(String.valueOf(negNum));
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
        String currentNumStr = this.currentNum;

        /*
        CODE FOR KEEPING PREVIOUS CALC ON fullEquation UNTIL NEW CALC IS STARTED
        TO FIX: FIRST NUMBERS IN A CALC SUCH AS 1234 WILL RESET AND APPEAR INDIVIDUALLY ON fullEquation
        UNTIL OPERATION IS CHOSEN
        EX:
        User Select 123
        fullEquation shows 3 (shows 1 until 2 is pressed, 2 until 3 is pressed, etc.)
        Should show 123

        String firstNumStr = this.firstNum;
        String fullEquationStr = String.valueOf(this.fullEquation);

        if (Objects.equals(firstNumStr, "") && (fullEquationStr.contains("="))){
            fullEquation.clear();
        }

         */
        if (Objects.equals(num, "0") && (Objects.equals(currentNumStr, "0"))) {
            fullEquation.appendText(num);
        }
        else if (Objects.equals(currentNumStr, "0")){
            currentNum = num;
            fullEquation.appendText(currentNum);
            text_space.setText(currentNum);
        }
        else {
            currentNum += num;
            fullEquation.appendText(num);
            text_space.setText(currentNum);
        }
    }

    @FXML
    public void prepareCalc(String calcOperation){
        this.calcOperation = calcOperation;
        firstNum = currentNum;
        currentNum = "0";
    }
    @FXML
    void calculate(){

        double firstNumDouble = Double.parseDouble(firstNum);
        double secondNumDouble = Double.parseDouble(currentNum);
        double finalNum;

        switch (calcOperation) {
            case "-" -> { //subtraction case

                finalNum = firstNumDouble - secondNumDouble;
                setOperationText(finalNum);
            }
            case "+" -> { //addition case

                finalNum = firstNumDouble + secondNumDouble;
                setOperationText(finalNum);
            }
            case "*" -> { //multiplication case

                finalNum = firstNumDouble * secondNumDouble;
                setOperationText(finalNum);
            }
            case "/" -> { //division case
                if (firstNumDouble == 0){
                    finalNum = 0;
                    setOperationText(finalNum);

                }
                else if (secondNumDouble == 0) {
                    fullEquation.appendText("Infinity");
                    text_space.setText("Infinity");

                }
                else {
                    finalNum = firstNumDouble / secondNumDouble;
                    setOperationText(finalNum);
                }
            }
        }
    }

    void setOperationText(double finalNum){
        fullEquation.appendText(String.valueOf(finalNum));
        text_space.setText(String.valueOf(finalNum));
        currentNum = String.valueOf(finalNum);
    }


}
/* TO DO

        fix fullequation so that it doesnt show 0 when clicked (ex: 0 is pressed first, then 3, shows 03)
        fix fullequation textfield when second number is negative (add parenthesis around it?)
        add functionality to % and decimal button


 */