package domain;

public class Customer extends User{
    private int Id;


    public Customer(String firstName, String lastName, int age, int customerId) {
        super(firstName, lastName, age);
        this.Id = customerId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int customerId) {
        this.Id = customerId;
    }
    @Override
    public String toString() {
        return "Customer ID: " + Id + "\n" +
                "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "Age: " + getAge();
    }
}
