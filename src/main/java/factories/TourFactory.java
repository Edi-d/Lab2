package factories;
import domain.Tour;

// Factory interface
public interface TourFactory<ObjectType extends Tour> {
    ObjectType createTour(int Id, String name, String description);
}


