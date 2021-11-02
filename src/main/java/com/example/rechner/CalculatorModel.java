package com.example.rechner;

public class CalculatorModel {
    private Double value;
    private String entry;

    public CalculatorModel () {
        this.value = 0.0;
        this.entry = "";
    }

    public void addKey(Character ch) {
        entry += ch;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
