package domain;

public class Tour implements Identifiable {
    private int Id;
    private String name;
    private String description;
    private TourLocation location;

    public Tour(int Id, String name, String description, TourLocation location) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int tourId) {
        this.Id = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TourLocation getLocation() {
        return location;
    }

}
