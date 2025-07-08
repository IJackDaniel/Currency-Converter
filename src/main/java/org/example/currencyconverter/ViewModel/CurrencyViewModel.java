package org.example.currencyconverter.ViewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.currencyconverter.Model.ExchangeRate;
import org.example.currencyconverter.Repository.CurrencyRepository;
import org.example.currencyconverter.Model.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyViewModel {
    private final CurrencyRepository repository;
    private ExchangeRate model;
    private List<Currency> currencies = new ArrayList<>();

    private final StringProperty value = new SimpleStringProperty();
    private final StringProperty baseCurrency = new SimpleStringProperty();
    private final StringProperty requiredCurrency = new SimpleStringProperty();

    public CurrencyViewModel(CurrencyRepository repository, ExchangeRate model) {
        this.repository = repository;
        this.model = model;
        value.set(String.valueOf(model.getValue()));
        baseCurrency.set(model.getBase());
        requiredCurrency.set(model.getRequiredCurrency());
    }

    public void loadExchangeRates() throws Exception {
        model = repository.getExchangeRates(baseCurrency.get());
        this.currencies.clear();

        for (String currencyCode : model.getRates().keySet()) {
            Double rate = model.getRates().get(currencyCode);
            String currencyName = getCurrencyName(currencyCode);
            currencies.add(new Currency(currencyCode, currencyName, rate));
        }
    }

    // Getters for properties
    public StringProperty valueProperty() {
        return value;
    }

    public StringProperty baseCurrencyProperty() {
        return baseCurrency;
    }

    public StringProperty requiredCurrencyProperty() {
        return requiredCurrency;
    }

    private String getCurrencyName(String code) {
        return switch (code) {
            case "USD" -> "US Dollar";
            case "EUR" -> "Euro";
            case "GBP" -> "British Pound";
            case "JPY" -> "Japanese Yen";
            case "RUB" -> "Russian Ruble";
            default -> code;
        };
    }
}
