package org.example.currencyconverter.ViewModel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.currencyconverter.Model.ExchangeRate;
import org.example.currencyconverter.Repository.CurrencyRepository;
import org.example.currencyconverter.Model.Currency;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CurrencyViewModel {
    private final CurrencyRepository repository;
    private ExchangeRate model;
    private List<Currency> currencies = new ArrayList<>();

    private final StringProperty value = new SimpleStringProperty();
    private final StringProperty baseCurrency = new SimpleStringProperty();
    private final StringProperty requiredCurrency = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();

    public CurrencyViewModel(CurrencyRepository repository, ExchangeRate model) {
        this.repository = repository;
        this.model = model;
        value.set(String.valueOf(model.getValue()));
        baseCurrency.set(model.getBase());
        requiredCurrency.set(model.getRequiredCurrency());
        result.set(String.valueOf(model.getResult()));

        value.addListener((obs, oldVal, newVal) -> {
            try {
                model.setValue(Double.parseDouble(newVal));
            } catch (NumberFormatException e) {
                model.setValue(0);
            }
        });

        baseCurrency.addListener((obs, oldVal, newVal) -> {
            model.setBase(newVal);
        });

        requiredCurrency.addListener((obs, oldVal, newVal) -> {
            model.setRequiredCurrency(newVal);
        });
    }

    public void loadExchangeRates() throws Exception {
        model.setRates(repository.getExchangeRates(baseCurrency.get()));
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

    public StringProperty resultProperty() {
        return result;
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

    public void solve() {
        model.evaluate();
        result.set(String.format("%.3f", model.getResult()));
    }

    public boolean isValidDouble(String input) {
        return input.matches("-?\\d*\\.?\\d*");
    }

    public void printAllFromModelForDebug() {
        System.out.println(model.getBase());
        System.out.println(model.getValue());
        System.out.println(model.getRequiredCurrency());
        System.out.println(model.getRates());
        System.out.println(model.getResult());
        System.out.println();
    }
}
