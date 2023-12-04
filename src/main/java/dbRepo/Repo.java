package dbRepo;

import database.Connect_db;

import java.sql.Connection;
import java.sql.SQLException;

public class Repo {

    public Connect_db dbConnection;
    public CustomerRepo customerDatabaseRepository;
    public GuideRepo gudiesDatabaseRepository;
    public PaymentRepo paymentDatabaseRepository;
    public LocationRepo locationDatabaseRepository;
    public TourRepo tourDatabaseRepository;
    public BookingRepo bookingDatabaseRepository;



    public Repo(){
        customerDatabaseRepository = new CustomerRepo();
        gudiesDatabaseRepository = new GuideRepo();
        paymentDatabaseRepository = new PaymentRepo();
        locationDatabaseRepository = new LocationRepo();
        tourDatabaseRepository = new TourRepo();
        bookingDatabaseRepository = new BookingRepo();
    }

}
