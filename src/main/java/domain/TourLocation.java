package domain;

public class TourLocation implements Identifiable {
    private int Id;
    private String name;
    private String description;
    private String location;
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public TourLocation(int Id, String name, String description, String location) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    @Override
    public int getId() {
        return Id;
    }
}
