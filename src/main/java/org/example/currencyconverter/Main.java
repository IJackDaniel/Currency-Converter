package org.example.currencyconverter;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.currencyconverter.Model.ExchangeRate;
import org.example.currencyconverter.Repository.CurrencyRepository;
import org.example.currencyconverter.View.View;
import org.example.currencyconverter.ViewModel.CurrencyViewModel;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        ExchangeRate model = new ExchangeRate();
        CurrencyRepository repository = new CurrencyRepository();

        CurrencyViewModel viewModel = new CurrencyViewModel(repository, model);

        new View(stage, viewModel);
    }
}
