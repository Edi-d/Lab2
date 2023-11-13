package domain;

public class Subscriber implements Identifiable{
    private static Subscriber instance;

    private int Id;
    private String name;
    private String email;

    private Subscriber(int Id, String name, String email) {
        this.Id = Id;
        this.name = name;
        this.email = email;
    }

    public static Subscriber createInstance(int Id, String name, String email) {
        if (instance == null) {
            instance = new Subscriber(Id, name, email);
        }
        return instance;
    }

    public void setId(int subscriberId) {
        this.Id = subscriberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String subscriberName) {
        this.name = subscriberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String subscriberEmail) {
        this.email = subscriberEmail;
    }

    public void notifySubscriber() {
        System.out.println("Notifying subscriber " + name + " at " + email);
    }

    @Override
    public int getId() {
        return Id;
    }
}
