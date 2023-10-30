package domain;

public class LocationMapping {
    private int locationId;
    private String name;
    private String description;

    public LocationMapping(int locationId, String name, String description) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
