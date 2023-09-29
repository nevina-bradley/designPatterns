package com.nevinabradley.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        Pattern pattern = new Pattern();

        Observer user1 = new User("User 1");
        Observer user2 = new User("User 2");

        pattern.addObserver(user1);
        pattern.addObserver(user2);

        pattern.notifyObservers("New resource created.");
    }
}

interface Observer {
    void update(String message);
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class Pattern {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
