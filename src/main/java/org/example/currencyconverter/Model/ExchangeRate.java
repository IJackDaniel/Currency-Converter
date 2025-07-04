package org.example.currencyconverter.Model;

import java.util.Date;
import java.util.Map;

public class ExchangeRate {
    private String base;                // Base currency
    private Date date;                  // Date of last update
    private Map<String, Double> rates;  // Pairs: Currency - Value;

    public ExchangeRate(String base, Date date, Map<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    // Getters
    public String getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    // Setters
    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
