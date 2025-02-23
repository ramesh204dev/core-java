package com.test;
/*
 * Imagine an online booking system that supports different types of
 *  transport options like Car, Train, and Flight.
 *   Each transport mode has common features like bookTicket() 
 *   but also has specific behavior such as calculateFare().

 Solution: Use an Abstract Class
Since all transport types share common behavior
 but have different implementations of fare calculation, we use an abstract class.
 */
// Abstract Class
abstract class Transport {
    protected String source;
    protected String destination;

    public Transport(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    // Abstract method (must be implemented by subclasses)
    abstract double calculateFare();

    // Concrete method (shared behavior)
    public void bookTicket() {
        System.out.println("Ticket booked from " + source + " to " + destination);
        System.out.println("Total Fare: $" + calculateFare());
    }
}

// Subclass: Car Transport
class Car extends Transport {
    private double distance; // in km
    private static final double RATE_PER_KM = 0.5; // $0.5 per km

    public Car(String source, String destination, double distance) {
        super(source, destination);
        this.distance = distance;
    }

    @Override
    double calculateFare() {
        return distance * RATE_PER_KM;
    }
}

// Subclass: Train Transport
class Train extends Transport {
    private static final double FIXED_TICKET_PRICE = 25.0;

    public Train(String source, String destination) {
        super(source, destination);
    }

    @Override
    double calculateFare() {
        return FIXED_TICKET_PRICE; // Fixed price for all train tickets
    }
}

// Subclass: Flight Transport
class Flight extends Transport {
    private static final double BASE_FARE = 100.0;
    private double distance; // in km
    private static final double RATE_PER_KM = 1.2; // $1.2 per km

    public Flight(String source, String destination, double distance) {
        super(source, destination);
        this.distance = distance;
    }

    @Override
    double calculateFare() {
        return BASE_FARE + (distance * RATE_PER_KM);
    }
}

//Interface for Discount
interface Discount {
 double applyDiscount(double fare);
}

//Implementing Student Discount
class StudentDiscount implements Discount {
 @Override
 public double applyDiscount(double fare) {
     return fare * 0.9; // 10% discount
 }
}

//Implementing Senior Citizen Discount
class SeniorCitizenDiscount implements Discount {
 @Override
 public double applyDiscount(double fare) {
     return fare * 0.8; // 20% discount
 }
}




// Main class to test
public class AbstractExampleMain {
    public static void main(String[] args) {
        Transport carTrip = new Car("New York", "Boston", 300);
        carTrip.bookTicket();

        System.out.println();

        Transport trainTrip = new Train("Los Angeles", "San Francisco");
        trainTrip.bookTicket();

        System.out.println();

        Transport flightTrip = new Flight("Chicago", "Miami", 1200);
        flightTrip.bookTicket();
        
      //Updating the main class to apply discounts
        
        Transport flightTrip_new = new Flight("New York", "Los Angeles", 1500);
        double baseFare = flightTrip_new.calculateFare();

        Discount studentDiscount = new StudentDiscount();
        double finalFare = studentDiscount.applyDiscount(baseFare);

        System.out.println("Base Fare: $" + baseFare);
        System.out.println("Final Fare after Student Discount: $" + finalFare);
    }
}
