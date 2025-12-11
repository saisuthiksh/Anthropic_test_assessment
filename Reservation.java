public class Reservation {

/*    - Create a `Reservation` class that represents a user's flight reservation, with these attributes:
            - `customerName` (String)
            - `flight` (Flight)
            - `seatsBooked` (int)*/

    private String customerName;
    private Flight flight;
    private int seatsBooked;

    public Reservation(String customerName, Flight flight, int seatsBooked) {
        this.customerName = customerName;
        this.flight = flight;
        this.seatsBooked = seatsBooked;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    @Override
    public String toString() {
        return "CustomerName='" + customerName + '\'' +
                ", flight=" + flight +
                ", seatsBooked=" + seatsBooked ;
    }

}
