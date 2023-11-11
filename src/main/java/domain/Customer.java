package domain;

public class Customer extends User{
    private int Id;


    public Customer(int Id, String firstName, String lastName, int age) {
        super(Id, firstName, lastName, age);
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
