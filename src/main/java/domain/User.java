package domain;

abstract public class User implements Identifiable{
    private int Id;
    private String firstName;
    private String lastName;
    private int age;

    public User(int Id, String firstName, String lastName, int age) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId(){
        return Id;
    }

}
