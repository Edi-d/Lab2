package factories;
import domain.CyclingTour;

public class CyclingTourFactory implements TourFactory<CyclingTour> {
    @Override
    public CyclingTour createTour(int Id, String name, String description) {
        return new CyclingTour(Id, name, description);
    }
}