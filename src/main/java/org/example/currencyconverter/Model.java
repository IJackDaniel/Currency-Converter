package org.example.currencyconverter;

public class Model {
    private double firstValue;
    private double secondValue;

    public Model() {
        firstValue = 0.0;
        secondValue = 0.0;
    }

    // First Value
    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    // Second Value
    public double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }
}
