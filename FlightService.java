import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class FlightService {

    /*- Implement a `FlightService` class that supports the following functionalities:
            - `List<Flight> searchForFlights(String destination, LocalDateTime date)`: Returns a list of available
    flights to the given destination on a specified date.
- `Reservation bookFlight(String customerName, Flight flight, int seats)`: Books the specified
    number of seats for a customer on a given flight.
            - Ensure that if the `availableSeats` goes below zero, the booking does not proceed.*/

    private List<Flight> flights = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Reservation bookFlight(String customerName, Flight flight, int seats) {
        if (flight.getAvailableSeats() >= seats)
        {
            flight.setAvailableSeats(flight.getAvailableSeats() - seats);
            Reservation reservation = new Reservation(customerName, flight, seats);
            reservations.add(reservation);
            return reservation;
        }
        return null;
    }

    public List<Flight> searchForFlights(String destination, LocalDateTime date) {
        LocalDate searchDate = date.toLocalDate();
        List<Flight> flightsList = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDestination().equalsIgnoreCase(destination) &&
                    f.getDepartureTime().toLocalDate().equals(searchDate)) {

                flightsList.add(f);
            }
        }
        return flightsList;
    }

    public List<Reservation> getReservationsForCustomer(String customerName) {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getCustomerName().equalsIgnoreCase(customerName)) {

                customerReservations.add(r);
            }
        }
        return customerReservations;
    }

}
