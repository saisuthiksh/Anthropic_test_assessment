import java.time.LocalDateTime;

public class Flight {

/*
    - Create a `Flight` class with the following attributes:
            - `flightNumber` (String)
            - `destination` (String)
            - `departureTime` (LocalDateTime)
            - `availableSeats` (int)
*/


    private String destination;
    private LocalDateTime departureTime;
    private String flightNumber;
    private int availableSeats;

    public Flight(String flightNumber, String destination, LocalDateTime departureTime, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return flightNumber + " -> " + destination + " [" + availableSeats + " seats]";
    }
}
