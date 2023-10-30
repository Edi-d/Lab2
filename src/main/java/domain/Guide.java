package domain;

public class Guide extends User{
    private int guideId;

    public int getId() {
        return guideId;
    }

    public void setiId(int guideId) {
        this.guideId = guideId;
    }

    public Guide(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
}