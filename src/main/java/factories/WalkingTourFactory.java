package factories;
import domain.WalkingTour;

public class WalkingTourFactory implements TourFactory<WalkingTour> {

    @Override
    public WalkingTour createTour(int Id, String name, String description, float price) {
        return null;
    }
}
