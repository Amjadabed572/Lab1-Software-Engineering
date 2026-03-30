package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Reads user credentials from file, validates them, and outputs valid users sorted by email.
 */
public class UsersApp {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        
        try (PrintWriter writer = new PrintWriter(new java.io.FileWriter("output.txt"))) {
            try {
                // Read from users.txt
                File file = new File("users.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue;

                    // Split by whitespace to get username and password
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        String username = parts[0];
                        String password = parts[1];

                        try {
                            User user = new User(username, password);
                            users.add(user);
                        } catch (Exception e) {
                            // Skip invalid entries
                        }
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                String output = "Error: users.txt file not found. Please ensure it is in the project directory.";
                System.out.println(output);
                writer.println(output);
            }

            // Sort users alphabetically by email
            users.sort(Comparator.comparing(User::getUsername));

            // Output valid users to console and file
            for (User user : users) {
                String output = user.toString();
                System.out.println(output);
                writer.println(output);
            }
        } catch (java.io.IOException e) {
            System.out.println("Error writing to output.txt: " + e.getMessage());
        }
    }
}