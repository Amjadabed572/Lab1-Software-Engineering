package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.Objects;

/**
 * Controller for the params screen.
 * Accepts n (max failed attempts) and t (block duration in seconds) from the user
 * before opening the login screen.
 */
public class ParameterController {

    @FXML
    private TextField maxAttemptsField;

    @FXML
    private TextField blockDurationField;

    @FXML
    private Label errorLabel;

    // Called when the Start button is clicked
    @FXML
    void onStartButtonClick(ActionEvent event) {
        String nText = maxAttemptsField.getText().trim();
        String tText = blockDurationField.getText().trim();

        // Validate that both fields are filled
        if (nText.isEmpty() || tText.isEmpty()) {
            errorLabel.setText("Please enter both values.");
            return;
        }

        // Validate that both fields are valid positive numbers
        try {
            int n = Integer.parseInt(nText);
            int t = Integer.parseInt(tText);

            if (n <= 0 || t <= 0) {
                errorLabel.setText("Please enter positive numbers only.");
                return;
            }

            // Create the LoginManager with the given parameters
            LoginManager loginManager = new LoginManager(n, t);
            MainApp.setLoginManager(loginManager);

            // Open the login screen
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Users Login");

        } catch (Exception e) {
            errorLabel.setText("Please enter valid numbers.");
        }
    }
}