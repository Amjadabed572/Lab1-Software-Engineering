package com.example.lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// The Controller acts as the "brain" for your login.fxml screen
public class LoginController {

    // @FXML connects these variables to the visual elements you created in SceneBuilder
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // A list to store only the users that pass your strict validation rules
    private final ArrayList<User> validUsers = new ArrayList<>();

    // initialize() is a special JavaFX method that automatically runs the moment the screen loads
    @FXML
    public void initialize() {
        try {
            // Read the text file as soon as the app starts
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    try {
                        // The User constructor throws an exception if the format is bad.
                        // If it succeeds, the user is valid and added to our list.
                        User user = new User(parts[0], parts[1]);
                        validUsers.add(user);
                    } catch (Exception e) {
                        // We intentionally ignore invalid users for this lab
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            errorLabel.setText("System Error: users.txt not found");
        }
    }

    // This method is triggered specifically when the user clicks the "login" button
    @FXML
    void onLoginButtonClick(ActionEvent event) {
        // Grab the text the user actually typed into the boxes
        String inputUser = usernameField.getText();
        String inputPass = passwordField.getText();

        boolean isMatch = false;

        // Loop through our list of valid users to see if the credentials match
        for (User u : validUsers) {
            if (u.getUsername().equals(inputUser) && u.getPassword().equals(inputPass)) {
                isMatch = true;
                break; // Stop looking once we find a match
            }
        }

        if (isMatch) {
            try {
                // Credentials match! Load the visual layout for the welcome screen
                Parent welcomeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));

                // Find the current window (Stage) based on the button that was clicked
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Swap the old login scene for the new welcome scene
                stage.setScene(new Scene(welcomeRoot));
                stage.setTitle("Welcome");
            } catch (Exception e) {
                // Show the error on the screen instead of the console
                errorLabel.setText("System Error: Could not load welcome screen.");
            }
        } else {
            // Credentials don't match! Show the exact error text required by the lab
            errorLabel.setText("user or password do not match");
        }
    }
}