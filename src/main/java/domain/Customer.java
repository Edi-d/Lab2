package domain;

public class Customer extends User{
    private int userId;

    public Customer(String firstName, String lastName, int age, int userId) {
        super(firstName, lastName, age);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
