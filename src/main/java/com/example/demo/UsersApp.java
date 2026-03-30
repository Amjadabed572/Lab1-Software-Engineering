package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UsersApp {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        try {
            // Read from the input file
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue; // Skip empty lines

                // Split by one or more spaces as per instructions
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];

                    try {
                        // Attempt to create a new User
                        User user = new User(username, password);
                        users.add(user); // Add to list if successful
                    } catch (Exception e) {
                        // Change System.out to System.err
                        System.err.println(line + " " + e.getMessage());
                    }
                } else {
                    // Failsafe for lines that don't have both parts
                    System.out.println(line + " Please enter a valid Email as username");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: users.txt file not found. Please ensure it is in the project directory.");
        }

        // Sort the valid users alphabetically by their username (Email)
        users.sort(Comparator.comparing(User::getUsername));

        // Print the sorted array of valid users
        for (User user : users) {
            System.out.print(user.toString() + "\n");
        }
    }
}