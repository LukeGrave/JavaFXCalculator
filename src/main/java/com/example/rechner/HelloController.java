package com.example.rechner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class HelloController {
    CalculatorModel myCalculation;
//    private Integer counter;

    public HelloController() {
//        counter = 0;
        myCalculation = new CalculatorModel();
    }

    @FXML
    private TextArea entry;

    @FXML
    protected void onButtonClick0() {
        myCalculation.addKey('0');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick1() {
        myCalculation.addKey('1');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick2() {
        myCalculation.addKey('2');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick3() {
        myCalculation.addKey('3');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick4() {
        myCalculation.addKey('4');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick5() {
        myCalculation.addKey('5');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick6() {
        myCalculation.addKey('6');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick7() {
        myCalculation.addKey('7');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick8() {
        myCalculation.addKey('8');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClick9() {
        myCalculation.addKey('9');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickPlus() {
        myCalculation.addKey('+');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickMinus() {
        myCalculation.addKey('-');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickMulti() {
        myCalculation.addKey('*');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickDiv() {
        myCalculation.addKey('/');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickChangeSign() {
        String pre = "-1*(";
        String post = ")";
        myCalculation.setEntry(pre + entry.getText() + post);
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickClearAll() {
        entry.setText("");
        myCalculation.setEntry("");
    }

    @FXML
    protected void onButtonClickOpen() {
        myCalculation.addKey('(');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickClose() {
        myCalculation.addKey(')');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickSqrt() {
        myCalculation.addKey('²');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickPoint() {
        myCalculation.addKey('.');
        entry.setText(myCalculation.getEntry());
    }

    @FXML
    protected void onButtonClickEquals(){
        String equation = entry.getText();
        String[] splitEquation = equation.split("(?<=[-+*/()])|(?=[-+*/()])"); //?<=[Look behind] and ?=[look ahead] insertions
        ArrayList<String> equationArray = new ArrayList<>();
        for (int i = 0; i < splitEquation.length; i++){
            equationArray.add(splitEquation[i]);
        }
//        boolean calculating = true;
        ArrayList<String> temp = new ArrayList<>();
        double x, y, z;
        char sign = 0;
        //Search for Brackets
        temp = getBracketEquation(equationArray);
        getSign(temp, sign);
        if(sign == 0){

            //temp or equation is done

        } else {
            //calculate
            x = getLeftSide(temp);
            y = getRightSide(temp);
            calculate(temp, x, sign, y);
        }
    }

    private double getRightSide(ArrayList<String> temp) {
        return 0;
    }

    private double getLeftSide(ArrayList<String> temp) {
        return 0;
    }

    private void getSign(ArrayList<String> temp, char sign) {
        String s;

        for (int i = 0; i < temp.size(); i++) {
            s = temp.get(i);
            if (s.equals('/')) {
                sign = '/';
            } else if (s.equals('*')) {
                sign = '*';
            } else if (s.equals('+')) {
                sign = '+';
            } else if (s.equals('-')) {
                sign = '-';
            }
        }
    }


    private double calculate(ArrayList<String> equation, double x, char sign, double y) {
        double z = 0;
        switch (sign){
            case '/':
                z = x / y;
            case '*':
                z = x * y;
            case '+':
                z = x + y;
            case '-':
                z = x - y;
            default:
        }
        return z;
    }

    public ArrayList<String> getBracketEquation(ArrayList<String> equation) {
        //Search for Brackets
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < equation.size(); i++) {
            if (equation.equals('(')) {
                    for (int j = (i+1); j < equation.size();j++){   //ohne '('
                        if(equation.equals(')')){                   //ohne ')'
                            return temp;
                        } else {
                            temp.add(String.valueOf(equation.get(j)));
                        }
                        //add ERROR if missing ')' and not on last spot
                    }
                }
           }
        return equation;
    }

//    public splitByBracket(){
//
//    }

}