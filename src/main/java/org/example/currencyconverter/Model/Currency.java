package org.example.currencyconverter.Model;

// Base Model of Currency
public class Currency {
    private String code;  // Code of Currency
    private String name;  // Name of Currency
    private double rate;  // Exchange rate relative to the base currency

    public Currency(String code, String name, double rate) {
        this.code = code;
        this.name = name;
        this.rate = rate;
    }


    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %.4f", name, code, rate);
    }
}
