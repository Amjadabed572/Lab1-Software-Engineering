package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

// Extending Application is required for this class to be a JavaFX program
public class MainApp extends Application {

    // The start method is where the visual window is built and displayed
    // "primaryStage" represents the physical window on your screen
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load the login screen FXML
        // Objects.requireNonNull ensures the program safely checks that "login.fxml" actually exists before loading it
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));

        // Sets the text at the top of the window frame
        primaryStage.setTitle("Users Login");

        // Places your visual layout (the Parent root) inside the window
        primaryStage.setScene(new Scene(root));

        // Makes the window visible to the user
        primaryStage.show();
    }

}