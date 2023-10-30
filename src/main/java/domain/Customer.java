package domain;

public class Customer extends User{
    private int customerId;

    public Customer(String firstName, String lastName, int age, int customerId) {
        super(firstName, lastName, age);
        this.customerId = customerId;
    }

    public int getcustomerId() {
        return customerId;
    }

    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }
}
