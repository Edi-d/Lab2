package controller;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    private List<String> subscribers;

    public Observer() {
        subscribers = new ArrayList<>();
        // Adding some predefined email addresses for reference
        subscribers.add("edi@gmail.com");
        subscribers.add("user2@example.com");
        subscribers.add("user3@example.com");
    }

    public void subscribe(String subscriber) {
        subscribers.add(subscriber);
    }

    ArrayList<String> getSubscribers() {
        return (ArrayList<String>) subscribers;
    }

    public void unsubscribe(String subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (String subscriber : subscribers) {
            System.out.println("Notifying subscriber: " + subscriber);
            // Here, you would typically send an email or a notification
            // For demonstration, it's just a print statement.
        }
    }

}
