# Flight Reservation System

Welcome to the Flight Reservation System! This is a lightweight, command-line Java application designed to demonstrate a basic flight booking workflow.

## 🚀 Features

*   **Search Flights**: Filter flights by destination and date.
*   **Book Seats**: secure your spot on a flight (inventory is tracked!).
*   **Manage Reservations**: View all bookings associated with a customer name.
*   **Pre-loaded Data**: Comes with a set of mock flights for immediate testing.

## 🛠️ Setup & Run

Ensure you have **Java 21+** installed.

1.  **Compile**:
    ```bash
    javac Main.java
    ```

2.  **Run**:
    ```bash
    java Main
    ```

## 📝 Usage Example

1.  Start the app.
2.  Choose **Option 1** to search (Try Destination: `SLC`, Date: `2026-01-01`).
3.  Choose **Option 2** to booking a flight using the flight number from the search results.
4.  Choose **Option 3** to verify your reservation.

## 📦 Project Structure

*   `Main.java`: Entry point and UI logic.
*   `FlightService.java`: Core business logic (search, book, storage).
*   `Flight.java`: Model for flight details.
*   `Reservation.java`: Model for booking details.
