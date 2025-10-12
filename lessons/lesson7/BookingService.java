package lessons.lesson7;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingService implements Serializable {
    private Airplane airplane;
    private Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "booking.dat";

    public BookingService() {
        airplane = new Airplane();
        airplane.loadSeatsFromFile(FILE_NAME);
    }

    public void run() {
        int choice = -1;
        while (choice != 0) {

            System.out.println("1. Show all seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. Pay for booking");
            System.out.println("5. Seat information");
            System.out.println("0. Exit");


            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: please enter a num");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> airplane.showSeats();
                case 2 -> bookSeat();
                case 3 -> cancelBooking();
                case 4 -> paySeat();
                case 5 -> seatInfo();
                case 0 -> exit();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void bookSeat() {
        try {
            System.out.print("Enter seat number (e.g., 3B): ");
            String seatNum = scanner.nextLine();
            Seat seat = airplane.findSeat(seatNum);

            if (seat == null) throw new Exception("Seat does not exist!");
            if (!"FREE".equals(seat.getStatus())) throw new Exception("Seat not available!");

            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) throw new Exception("Name cannot be empty.");

            seat.book(name);
            System.out.println("Seat successfully booked!");
        } catch (Exception e) {
            System.out.println("Booking error: " + e.getMessage());
        }
    }

    private void cancelBooking() {
        try {
            System.out.print("Enter seat number: ");
            String seatNum = scanner.nextLine();
            Seat seat = airplane.findSeat(seatNum);

            if (seat == null) throw new Exception("Seat does not exist!");
            if ("FREE".equals(seat.getStatus())) throw new Exception("Seat is not booked.");

            seat.cancelBooking();
            System.out.println("Booking canceled.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void paySeat() {
        try {
            System.out.print("Enter seat number: ");String seatNum = scanner.nextLine();

            Seat seat = airplane.findSeat(seatNum);

            if (seat == null) throw new Exception("Seat does not exist!");
            if (!"BOOKED".equals(seat.getStatus())) throw new Exception("Only booked seats can be paid.");

            seat.pay();
            System.out.println("Seat paid!");
        } catch (Exception e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }

    private void seatInfo() {
        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine();
        Seat seat = airplane.findSeat(seatNum);

        if (seat == null) {
            System.out.println("Seat does not exist");
            return;
        }
        seat.checkExpiration();
        System.out.println(seat);
    }

    private void exit() {
        airplane.save(FILE_NAME);
        System.out.println("Data saved. ");
    }
}
