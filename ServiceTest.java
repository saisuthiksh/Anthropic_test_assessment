
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class ServiceTest {

    private FlightService service;
    private Flight americanAir;
    private Flight deltaAir;

    @BeforeEach
    void setUp() {
        service = new FlightService();
        americanAir = new Flight("JFK01", "JFK", LocalDateTime.parse("2026-01-15T10:00"), 10);
        deltaAir = new Flight("SLC01", "SLC", LocalDateTime.parse("2026-01-15T14:00"), 5);
        service.addFlight(americanAir);
        service.addFlight(deltaAir);
    }

    @Test
    void bookingFlight_onSuccess() {
        Reservation res = service.bookFlight("KBS", americanAir, 2);
        assertEquals("KBS", res.getCustomerName());
        assertNotNull(res);
        assertEquals(americanAir, res.getFlight());
        assertEquals(2, res.getSeatsBooked());
        assertEquals(8, americanAir.getAvailableSeats());
    }

    @Test
    void searchingForFlights_found() {
        List<Flight> results = service.searchForFlights("JFK", LocalDateTime.parse("2026-01-15T00:00"));
        assertEquals(1, results.size());
        assertEquals(americanAir, results.get(0));
    }

    @Test
    void searchingForFlights_notFound() {
        List<Flight> results = service.searchForFlights("SLC", LocalDateTime.parse("2026-11-15T00:00"));
        assertTrue(results.isEmpty());
    }

    @Test
    void searchForFlights_incorrectDate() {
        List<Flight> results = service.searchForFlights("JFK", LocalDateTime.parse("2026-01-16T00:00"));
        assertTrue(results.isEmpty());
    }

    @Test
    void bookingFlight_seatsUnavailable() {
        Reservation res = service.bookFlight("KBS", americanAir, 20);
        assertNull(res);
        assertEquals(10, americanAir.getAvailableSeats());
    }

    @Test
    void bookFlight_zeroSeats() {
        Reservation res = service.bookFlight("KBS", americanAir, 0);
        assertNotNull(res);
        assertEquals(10, americanAir.getAvailableSeats());
    }
}
