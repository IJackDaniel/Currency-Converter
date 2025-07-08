package org.example.currencyconverter.Model;

import java.util.Map;
import com.google.gson.annotations.SerializedName;
import javafx.util.converter.DateStringConverter;

public class ExchangeRate {
    @SerializedName("base_code")
    private String base;                // Base currency

    @SerializedName("time_last_update_uts")
    private String date;

    @SerializedName("conversion_rates")
    private Map<String, Double> rates;  // Pairs: Currency - Value;

    private double value;
    private String requiredCurrency;

    public ExchangeRate(String base, String date, Map<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
        this.value = 0;
    }

    public double evaluate() {
        return value * rates.get(requiredCurrency);
    }

    // Getters
    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public double getValue() {
        return value;
    }

    public String getRequiredCurrency() {
        return requiredCurrency;
    }

    // Setters
    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequiredCurrency(String requiredCurrency) {
        this.requiredCurrency = requiredCurrency;
    }
}
