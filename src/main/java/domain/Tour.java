package domain;

public class Tour {
    private int tourId;
    private String name;
    private String description;

    public Tour(int tourId, String name, String description) {
        this.tourId = tourId;
        this.name = name;
        this.description = description;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
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
}
