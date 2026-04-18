package com.example.demo; // The package/folder where this file is located

import javafx.fxml.FXML;

// A simple controller for the screen that appears after a successful login
public class WelcomeController {

    // initialize() is a special JavaFX method that runs automatically the moment the welcome.fxml screen loads.
    // Right now, it just prints a hidden confirmation to your console, but it is
    // set up perfectly if you ever want to add a "Logout" button or personalized text!
    @FXML
    public void initialize() {
        System.out.println("Welcome screen loaded successfully.");
    }
}