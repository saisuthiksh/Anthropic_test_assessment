//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    FlightService flightService = new FlightService();

    // DATA ENTRY
    flightService.addFlight(new Flight("BRKB01", "JFK", LocalDateTime.parse("2026-01-01T09:00"), 100));
    flightService.addFlight(new Flight("AMZN01", "SLC", LocalDateTime.parse("2026-01-01T08:00"), 150));
    flightService.addFlight(new Flight("AMZN02", "SLC", LocalDateTime.parse("2026-01-01T111:00"), 150));
    flightService.addFlight(new Flight("AMZN01", "ORD", LocalDateTime.parse("2026-01-02T10:00"), 200));
    flightService.addFlight(new Flight("GOOGL1", "LAX", LocalDateTime.parse("2026-01-03T11:00"), 300));

    Scanner scanner = new Scanner(System.in);
    int option;
    do {
        System.out.println("1. Search for flights ");
        System.out.println("2. Book flight ");
        System.out.println("3. View reservations ");
        System.out.println("4. Exit Application ");
        System.out.print("Enter your Choice: ");
        option = scanner.nextInt();
        scanner.nextLine();


        if (option == 1) {
            System.out.print("Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            LocalDateTime date = LocalDateTime.parse(dateStr + "T00:00");
            List<Flight> results = flightService.searchForFlights(destination, date);
            if (results.isEmpty()) {
                System.out.println("No flights found.");
            } else {
                for (int i = 0; i < results.size(); i++) {
                    System.out.println((i + 1) + ". " + results.get(i));
                }
            }
        } else if (option == 2) {

            System.out.print("Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            LocalDateTime date = LocalDateTime.parse(dateStr + "T00:00");
            List<Flight> results = flightService.searchForFlights(destination, date);
            if (results.isEmpty()) {
                System.out.println("No flights found.");
                continue;
            }
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
            System.out.print("Pick a flight (type the number shown): ");
            int flightIdx = scanner.nextInt() - 1;
            scanner.nextLine();
            if (flightIdx < 0 || flightIdx >= results.size()) {
                System.out.println("Invalid selection.");
                continue;
            }
            Flight selected = results.get(flightIdx);
            System.out.print("Customer name: ");
            String name = scanner.nextLine();
            System.out.print("Seats: ");
            int seats = scanner.nextInt();
            scanner.nextLine();
            Reservation res = flightService.bookFlight(name, selected, seats);
            if (res != null) {
                System.out.println("Booking successful: " + res);
            } else {
                System.out.println("Not enough seats available. ");
            }
        } else if (option == 3) {
            System.out.print("Customer name: ");
            String name = scanner.nextLine();
            List<Reservation> resList = flightService.getReservationsForCustomer(name);
            if (resList.isEmpty()) {
                System.out.println("No reservations found. ");
            } else {
                for (Reservation r : resList) {
                    System.out.println(r);
                }
            }
        } else if (option == 4)  {
            System.out.println("Exiting...");
        } else {
            System.out.println("Invalid option.");
        }
    } while (option != 4);
    scanner.close();
}
