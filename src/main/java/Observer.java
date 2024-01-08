import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import controller.CrudRepository;
import java.util.List;

public class Observer {

    private ArrayList<String> subscribers;
    private CrudRepository crudRepository;

    public Observer() {
        subscribers = new ArrayList<>();
        crudRepository = new CrudRepository();
    }

    public void subscribe(String subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(String subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (String subscriber : subscribers) {
            System.out.println("Notifying subscriber: " + subscriber);
        }
    }

    public void saveSubscribersToDatabase(Connection db) {
        String insertQuery = "INSERT INTO subscribers (subscriber_id) VALUES (?)";
        for (String subscriber : subscribers) {
            try {
                crudRepository.addObjectToDatabase(db, insertQuery, subscriber);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
