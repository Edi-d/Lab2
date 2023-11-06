package domain;

public class LocationMapping implements Identifiable {
    private int Id;
    private String name;
    private String description;

    public LocationMapping(int locationId, String name, String description) {
        this.Id = locationId;
        this.name = name;
        this.description = description;
    }

    public void setId(int locationId) {
        this.Id = locationId;
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

    @Override
    public int getId() {
        return Id;
    }
}
