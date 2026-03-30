package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * UsersApp reads user data from a file, validates and creates User objects,
 * sorts them alphabetically by username, and prints the results.
 * This is a simple console application for processing user lists.
 */
public class UsersApp {
    /**
     * Main method to execute the user processing application.
     * Reads from "users.txt", creates valid User objects, sorts, and prints them.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        try {
            // Read from the input file "users.txt"
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Split by one or more spaces
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];

                    try {
                        // Attempt to create a new User (validation happens in User constructor)
                        User user = new User(username, password);
                        users.add(user); // Add to list if successful
                    } catch (Exception e) {
                        // Log invalid user lines to stderr
                        System.err.println(line + " " + e.getMessage());
                    }
                } else {
                    // Handle lines without enough parts
                    System.out.println(line + " Please enter a valid Email as username");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: users.txt file not found. Please ensure it is in the project directory.");
        }

        // Sort the valid users alphabetically by username (email)
        users.sort(Comparator.comparing(User::getUsername));

        // Print the sorted list of valid users
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}