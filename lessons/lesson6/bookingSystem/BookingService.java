package lessons.lesson6.bookingSystem;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingService implements Serializable {
private Airplane airplane;
private Scanner scanner = new Scanner(System.in);
private static String FILE_NAME = "booking.dat";

public BookingService(){
    airplane= new Airplane();
    airplane.loadSeatsFromFile(FILE_NAME);
}
public void run() {
    int choice = -1;
    while (choice != 0) {
        System.out.println("1. Show all seats");
        System.out.println("2. Book a seat");
        System.out.println("3. Cancel booking");
        System.out.println("4. Seat information");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter a number!");
            scanner.nextLine();
            continue;
        }
        switch (choice) {
            case 1:
                airplane.showSeats();
                break;
            case 2:
                try {
                    bookSeat();
                } catch (Exception e) {
                    System.out.println("Booking error: " + e.getMessage());
                }
                break;
            case 3:
                try {
                    cancelBooking();
                } catch (Exception e) {
                    System.out.println("Cancellation error: " + e.getMessage());
                }
                break;
            case 4:
                seatInfo();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}

    private void bookSeat() throws Exception {
        System.out.print("Enter seat number (e.g., 3B): ");
        String seatNum = scanner.nextLine();
        Seat seat = airplane.findSeat(seatNum);

        if (seat == null) throw new Exception("Seat does not exist!");
        if (seat.isBooked()) throw new Exception("Seat is already booked!");

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        if (name.trim().length() == 0) throw new Exception("Name cannot be empty.");

        seat.book(name);
        System.out.println("Seat successfully booked!");
    }

    private void cancelBooking() throws Exception {
        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine();
        Seat seat = airplane.findSeat(seatNum);

        if (seat == null) throw new Exception("Seat does not exist!");
        if (!seat.isBooked()) throw new Exception("Seat is not booked.");

        seat.cancelBooking();
        System.out.println("Booking canceled.");
    }

    private void seatInfo() {
        System.out.print("Enter seat number: ");
        String seatNum = scanner.nextLine();
        Seat seat = airplane.findSeat(seatNum);

        if (seat == null) {
            System.out.println("Seat does not exist!");
            return;
        }
        System.out.println(seat);
    }

    private void exit() {
        airplane.save(FILE_NAME);
        System.out.println("Data saved");
    }
    }



