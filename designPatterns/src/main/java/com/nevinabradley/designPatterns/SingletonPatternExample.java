package com.nevinabradley.designPatterns;

public class SingletonPatternExample {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        connection1.connect();
        connection2.connect();

        if (connection1 == connection2) {
            System.out.println("Both connections to the database were successful.");
        }
    }
}

class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Successfully connected to the database!");
    }
}
