package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

// Extending Application is required for this class to be a JavaFX program
public class MainApp extends Application {

    // Shared LoginManager instance used by LoginController to manage attempts and blocking
    private static LoginManager loginManager;

    // Sets the LoginManager instance created in ParameterController
    public static void setLoginManager(LoginManager manager) {
        loginManager = manager;
    }

    // Returns the shared LoginManager instance to be used by LoginController
    public static LoginManager getLoginManager() {
        return loginManager;
    }

    // The start method is where the visual window is built and displayed
    // "primaryStage" represents the physical window on your screen
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load the parameter screen first where the user enters n and t
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("parameter.fxml")));

        // Sets the text at the top of the window frame
        primaryStage.setTitle("Setup");

        // Places your visual layout (the Parent root) inside the window
        primaryStage.setScene(new Scene(root));

        // Makes the window visible to the user
        primaryStage.show();
    }
}