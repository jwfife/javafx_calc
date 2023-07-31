package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;
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
    private Button button_zero;
    @FXML
    private Button button_one;
    @FXML
    private Button button_two;
    @FXML
    private Button button_three;
    @FXML
    private Button button_four;
    @FXML
    private Button button_five;
    @FXML
    private Button button_six;
    @FXML
    private Button button_seven;
    @FXML
    private Button button_eight;
    @FXML
    private Button button_nine;


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
        if (currentNumValue != 0){
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
        enableNumbers();
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
        enableNumbers();
    }

    @FXML
    void onAddButtonClick() {
        fullEquation.appendText(" + ");
        prepareCalc("+");
        enableNumbers();
    }

    @FXML
    void onMultiplyButtonClick() {
        fullEquation.appendText(" * ");
        prepareCalc("*");
        enableNumbers();
    }

    @FXML
    void onDivideButtonClick() {
        fullEquation.appendText(" / ");
        prepareCalc("/");
        enableNumbers();
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
        disableNumbers();
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
    void disableNumbers(){
        button_zero.setDisable(true);
        button_one.setDisable(true);
        button_two.setDisable(true);
        button_three.setDisable(true);
        button_four.setDisable(true);
        button_five.setDisable(true);
        button_six.setDisable(true);
        button_seven.setDisable(true);
        button_eight.setDisable(true);
        button_nine.setDisable(true);
    }

    @FXML
    void enableNumbers(){
        button_zero.setDisable(false);
        button_one.setDisable(false);
        button_two.setDisable(false);
        button_three.setDisable(false);
        button_four.setDisable(false);
        button_five.setDisable(false);
        button_six.setDisable(false);
        button_seven.setDisable(false);
        button_eight.setDisable(false);
        button_nine.setDisable(false);
    }

    @FXML
    public void setDigit(String num){
        String currentNumStr = this.currentNum;
        String fullEquationStr = String.valueOf(fullEquation.getText());
        char numChar = num.charAt(0);
        int pos;
        char[] fullEquationChars;
        char[] newFullEquationChar;
        String spaceStr = " ";

        /*
        Makes it so the first non-zero number entered into the calculator replaces the first spot,
        rather than appending to 0 (i.e. shows 5 instead of 05)
         */
        if (Objects.equals(currentNumStr, "0") && (fullEquationStr.length() == 1)){
            currentNum = num;
            fullEquation.setText(currentNum);
            text_space.setText(currentNum);
        }

        /*
        Appends the next entered value onto the previous before the operation is chosen.
        Essentially takes care of the first variable before moving onto operation.
         */
        else if (Objects.equals(currentNumStr, "0") && (!fullEquationStr.contains(" "))){
            currentNum = num;
            fullEquation.appendText(currentNum);
            text_space.setText(currentNum);
        }

        /*
        Section is for the second number after the operation type is entered
        Appends spaces in order to account for charArray replacing of values
        Does the same thing for the first number by swapping out 0 for the first non-zero entered
         */
        else if (Objects.equals(currentNumStr, "0")){
            currentNum = num;

            fullEquation.appendText(" ");
            fullEquation.appendText(" ");
            fullEquationStr = String.valueOf(fullEquation.getText());

            pos = fullEquationStr.length() - 2;

            fullEquationChars = fullEquationStr.toCharArray();
            fullEquationChars[pos] = numChar;

            /*
            If there is an extra space after a number is entered, i.e. "3 x 4 ", copies array over to new char array
            excluding the final character (the space)
            Sets fullEquationStr to the new char array.
            */
            if (String.valueOf((fullEquationChars[fullEquationChars.length - 1])).equals(spaceStr)){
                newFullEquationChar = Arrays.copyOfRange(fullEquationChars, 0, (fullEquationChars.length - 1));
                fullEquationStr = String.valueOf(newFullEquationChar);
            }

            //Otherwise, if there is no space, continues with the current/original full equation character array
            else {
                fullEquationStr = String.valueOf(fullEquationChars);
            }

            fullEquation.setText(fullEquationStr);
            text_space.setText(currentNum);

        }

        /*Adds extra numbers onto the currentNum (i.e. first variable is 32, to make it 321 you click 1, and it
        adds it to the end of the string and appends to the fullEquation)
         */
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