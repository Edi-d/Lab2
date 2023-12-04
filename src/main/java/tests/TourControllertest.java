//package tests;
//
//import controller.Controller;
//import domain.Booking;
//import domain.CyclingTour;
//import domain.Tour;
//import domain.WalkingTour;
//import factories.CyclingTourFactory;
//import factories.WalkingTourFactory;
//import org.junit.jupiter.api.Test;
//import repository.Repository;
//import repository.TourRepository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TourControllertest {
//    public Controller tourController;
//    private Repository<Tour> tourRepository;
//    @Test
//    public void testCreateTour() {
//        this.tourRepository = new TourRepository();
//        tourController = new Controller(tourRepository);
//        Tour walkingTour = tourController.createTour(1, "Walking Tour", "Explore the city on foot", "Walking", 50.0f);
//        tourController.add(walkingTour);
//        assertNotNull(walkingTour);
//        assertEquals("Walking Tour", walkingTour.getName());
//        assertEquals("Explore the city on foot", walkingTour.getDescription());
////        assertEquals(45.0f, walkingTour.getPrice());
//        assertTrue(walkingTour instanceof WalkingTour);
//
//        Tour cyclingTour = tourController.createTour(2, "Cycling Tour", "Enjoy a bike ride", "Cycling", 40.0f);
//        assertNotNull(cyclingTour);
//        assertEquals("Cycling Tour", cyclingTour.getName());
//        assertEquals("Enjoy a bike ride", cyclingTour.getDescription());
//        assertEquals(40.0f, cyclingTour.getPrice());
//        assertTrue(cyclingTour instanceof CyclingTour);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            tourController.createTour(3, "Unknown Tour", "Unknown description", "UnknownType", 30.0f);
//        });
//    }
//}
