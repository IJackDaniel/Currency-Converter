package org.example.currencyconverter.ViewModel;

import org.example.currencyconverter.Model.ExchangeRate;
import org.example.currencyconverter.Repository.CurrencyRepository;
import org.example.currencyconverter.Model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyViewModel {
    private final CurrencyRepository repository;
    private List<Currency> currencies = new ArrayList<>();

    public CurrencyViewModel(CurrencyRepository repository) {
        this.repository = repository;
    }

    public void loadExchangeRates(String baseCurrensy) throws Exception {
        ExchangeRate rates = repository.getExchangeRates(baseCurrensy);
        this.currencies.clear();

        for (Map.Entry<String, Double> entry : rates.getRates().entrySet()) {
            String currencyName = getCurrencyName(entry.getKey());
            currencies.add(new Currency(entry.getKey(), currencyName, entry.getValue()));
        }
    }

    public List<Currency> getCurrencies() {
        return new ArrayList<>(currencies);
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
