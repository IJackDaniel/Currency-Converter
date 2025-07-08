package org.example.currencyconverter.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.currencyconverter.ViewModel.CurrencyViewModel;
import java.util.Scanner;

public class View {
    private final CurrencyViewModel viewModel;

    public View (Stage stage, CurrencyViewModel viewModel) {
        this.viewModel = viewModel;
        setupUI(stage);
    }

    private void setupUI(Stage stage) {
        TextField baseCurrency = new TextField();
        TextField value = new TextField();
        TextField requiredCurrency = new TextField();

        baseCurrency.textProperty().bindBidirectional(viewModel.baseCurrencyProperty());
        value.textProperty().bindBidirectional(viewModel.valueProperty());
        requiredCurrency.textProperty().bindBidirectional(viewModel.requiredCurrencyProperty());

        Label resultField = new Label();

        Button estimateButton = new Button("Estimate!");

        VBox vBox = new VBox(10, baseCurrency, value, requiredCurrency);
        HBox root = new HBox(10, vBox, resultField, estimateButton);

        stage.setScene(new Scene(root, 300, 300));
        stage.setTitle("Currency Converter");
        stage.show();
    }
}

/*
public static void main(String[] args) {
        CurrencyRepository repository = new CurrencyRepository();
        CurrencyViewModel viewModel = new CurrencyViewModel(repository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Exchange Rates App");
        System.out.print("Enter base currency (e.g. USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        try {
            viewModel.loadExchangeRates(baseCurrency);

            System.out.println("\nAvailable currencies:");
            viewModel.getCurrencies().forEach(currency -> {
                System.out.printf("1 %s = %.4f %s (%s)%n",
                        baseCurrency,
                        currency.getRate(),
                        currency.getCode(),
                        currency.getName());
            });
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
 */
