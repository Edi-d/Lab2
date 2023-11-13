package domain;

public class Guide extends User{
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int guideId) {
        this.Id = guideId;
    }

    public Guide(int Id, String firstName, String lastName, int age, String email) {
        super(Id, firstName, lastName, age, email);
    }
}