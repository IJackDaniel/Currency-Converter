module org.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires java.sql;


    opens org.example.currencyconverter to javafx.fxml;
    opens org.example.currencyconverter.Model to com.google.gson;
    exports org.example.currencyconverter;
}