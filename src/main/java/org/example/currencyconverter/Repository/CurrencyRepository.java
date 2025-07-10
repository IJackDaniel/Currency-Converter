package org.example.currencyconverter.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.currencyconverter.Model.ExchangeRate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CurrencyRepository {
    private static final String API_KEY = "92339e4cf8297d94e8179f56";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Map<String, Double> getExchangeRates(String baseCurrency) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + API_KEY + "/latest/" + baseCurrency))
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("API request failed with code: " + response.statusCode());
        }

        // Парсим JSON и извлекаем только rates
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject ratesObject = jsonObject.getAsJsonObject("conversion_rates");

        Map<String, Double> rates = new HashMap<>();
        ratesObject.entrySet().forEach(entry -> {
            rates.put(entry.getKey(), entry.getValue().getAsDouble());
        });

        return rates;
    }

}
