package org.example.currencyconverter.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.example.currencyconverter.ViewModel.CurrencyViewModel;
import java.util.Scanner;

public class View {
    private final CurrencyViewModel viewModel;

    public View (Stage stage, CurrencyViewModel viewModel) {
        this.viewModel = viewModel;
        setupUI(stage);
    }

//    private void setupUI(Stage stage) {
//        TextField baseCurrency = new TextField();
//        TextField value = new TextField();
//        TextField requiredCurrency = new TextField();
//
//        baseCurrency.textProperty().bindBidirectional(viewModel.baseCurrencyProperty());
//        value.textProperty().bindBidirectional(viewModel.valueProperty());
//        requiredCurrency.textProperty().bindBidirectional(viewModel.requiredCurrencyProperty());
//
//        Label resultField = new Label("");
//        resultField.setStyle("-fx-background-color: blue");
//
//        Button estimateButton = new Button("Estimate!");
//
//        HBox hBox = new HBox(10, baseCurrency, value, requiredCurrency);
//
//
//        VBox root = new VBox(10, hBox, resultField, estimateButton);
//
//        stage.setScene(new Scene(root, 300, 300));
//        stage.setTitle("Currency Converter");
//        stage.show();
//    }
    private void setupUI(Stage stage) {
        // Create UI elements
        Label titleLabel = new Label("Currency Converter");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleLabel.setTextFill(Color.DARKBLUE);

        Label baseCurrencyLabel = new Label("Base Currency:");
        TextField baseCurrencyField = new TextField();
        baseCurrencyField.setPromptText("e.g. USD");
        baseCurrencyField.setMaxWidth(100);

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();
        amountField.setPromptText("e.g. 100");
        amountField.setMaxWidth(100);

        Label targetCurrencyLabel = new Label("Target Currency:");
        TextField targetCurrencyField = new TextField();
        targetCurrencyField.setPromptText("e.g. EUR");
        targetCurrencyField.setMaxWidth(100);

        // Bind properties
        baseCurrencyField.textProperty().bindBidirectional(viewModel.baseCurrencyProperty());
        amountField.textProperty().bindBidirectional(viewModel.valueProperty());
        targetCurrencyField.textProperty().bindBidirectional(viewModel.requiredCurrencyProperty());

        // Result display
        Label resultLabel = new Label("Result will appear here");
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        resultLabel.setTextFill(Color.GREEN);
        resultLabel.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px; -fx-border-color: #ccc; -fx-border-width: 1px;");
        resultLabel.setMaxWidth(Double.MAX_VALUE);
        resultLabel.setAlignment(Pos.CENTER);

        // Button
        Button convertButton = new Button("Convert");
        convertButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        convertButton.setMinWidth(150);

        // Layout
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(10));

        inputGrid.add(baseCurrencyLabel, 0, 0);
        inputGrid.add(baseCurrencyField, 1, 0);
        inputGrid.add(amountLabel, 0, 1);
        inputGrid.add(amountField, 1, 1);
        inputGrid.add(targetCurrencyLabel, 0, 2);
        inputGrid.add(targetCurrencyField, 1, 2);

        HBox buttonBox = new HBox(convertButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        VBox root = new VBox(15, titleLabel, inputGrid, buttonBox, resultLabel);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #ffffff;");

        // Set up the stage
        stage.setScene(new Scene(root, 350, 350));
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
