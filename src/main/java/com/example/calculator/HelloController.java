package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;


public class HelloController {
    @FXML
    private Button button_subtract;

    @FXML
    private Button button_add;

    @FXML
    private Button button_multiply;

    @FXML
    private Button button_divide;

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
        enableOperations();
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
    void onPercentButtonClick() {
        double percentVal = Double.parseDouble(currentNum);
        percentVal /= 100;

        currentNum = String.valueOf(percentVal);
        fullEquation.setText(String.valueOf(percentVal));
        text_space.setText(String.valueOf(percentVal));
    }

    @FXML
    void onEqualsButtonClick() {
        fullEquation.appendText(" = ");
        enableOperations();
        calculate();
    }

    @FXML
    void disableOperations(){
        button_subtract.setDisable(true);
        button_add.setDisable(true);
        button_divide.setDisable(true);
        button_multiply.setDisable(true);
    }

    @FXML
    void enableOperations(){
        button_subtract.setDisable(false);
        button_add.setDisable(false);
        button_divide.setDisable(false);
        button_multiply.setDisable(false);
    }

    @FXML
    public void setDigit(String num){
        String currentNumStr = this.currentNum;
        String fullEquationStr = String.valueOf(fullEquation.getText());
        char numChar = num.charAt(0);
        int pos;
        char[] fullEquationChars = fullEquationStr.toCharArray();


        if (Objects.equals(currentNumStr, "0") && (fullEquationStr.length() == 1)){
            currentNum = num;
            fullEquation.setText(currentNum);
            text_space.setText(currentNum);
        }
        else if ((Objects.equals(currentNumStr, "0")) && (!fullEquationStr.contains(" "))){
            currentNum = num;
            fullEquation.appendText(currentNum);
            text_space.setText(currentNum);
        }
        else if (Objects.equals(currentNumStr, "0")){
            currentNum = num;

            fullEquation.appendText(" ");
            fullEquationStr = String.valueOf(fullEquation.getText());

            System.out.println("-------");
            System.out.println("Full Eq after Space: " + fullEquationStr);

            pos = fullEquationStr.length() - 2;

            System.out.println("Position (-2) = " + pos);

            fullEquationChars[pos] = numChar;
            fullEquationStr = String.valueOf(fullEquationChars);

            System.out.println("Full Eq after replace: " + fullEquationStr);

            fullEquation.setText(fullEquationStr);
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
        disableOperations();
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

        fix fullequation textfield when second number is negative (add parenthesis around it?)
        add functionality to decimal button


 */