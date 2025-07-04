package org.example.currencyconverter.View;

import org.example.currencyconverter.ViewModel.CurrencyViewModel;
import org.example.currencyconverter.Repository.CurrencyRepository;
import java.util.Scanner;

public class View {
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
}
