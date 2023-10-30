package domain;

public class Guide extends User{
    private int guideId;

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public Guide(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
}