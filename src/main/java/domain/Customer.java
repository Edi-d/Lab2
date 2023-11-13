package domain;

public class Customer extends User{
    private int Id;


    public Customer(int Id, String firstName, String lastName, int age, String email) {
        super(Id, firstName, lastName, age, email);
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
