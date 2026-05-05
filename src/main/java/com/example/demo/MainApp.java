package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class MainApp extends Application {

    // Shared LoginManager instance used by LoginController
    private static LoginManager loginManager;

    // --- THIS IS THE METHOD THE COMPILER WAS LOOKING FOR ---
    public static void setLoginManager(LoginManager manager) {
        loginManager = manager;
    }

    // Returns the shared LoginManager instance
    public static LoginManager getLoginManager() {
        return loginManager;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the parameter screen first where the user enters n and t
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("parameter.fxml")));
        primaryStage.setTitle("Setup");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}