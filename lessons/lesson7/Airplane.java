package lessons.lesson7;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Airplane implements Serializable {
    private List<Seat> seats;
    private LocalDate flightDate;

    public Airplane() {
        seats = new ArrayList<>();
        flightDate = LocalDate.now().plusDays(3);
        initSeats();
    }

    public void initSeats() {
        String[] letters = {"A", "B", "C", "D"};
        for (int row = 1; row <= 5; row++) {
            for (String letter : letters) {
                seats.add(new Seat(row + letter, "Business class"));
            }
        }
        for (int row = 6; row <= 20; row++) {
            for (String letter : letters) {
                seats.add(new Seat(row + letter, "Economy class"));
            }
        }
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat findSeat(String seatNum) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equalsIgnoreCase(seatNum)) return seat;
        }
        return null;
    }

    public void showSeats() {
        System.out.println("Flight date: " + flightDate);
        System.out.println("\nBusiness class:");
        for (Seat seat : seats) {
            seat.checkExpiration();
            if ("Business class".equals(seat.getSeatClass())) {
                System.out.println(seat);
            }
        }

        System.out.println("\nEconomy class:");
        for (Seat seat : seats) {
            seat.checkExpiration();
            if ("Economy class".equals(seat.getSeatClass())) {
                System.out.println(seat);
            }
        }
    }

    public void save(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Flight and seats saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSeatsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Airplane loaded = (Airplane) ois.readObject();
            this.seats = loaded.getSeats();
            this.flightDate = loaded.getFlightDate();
            System.out.println("Flight data loaded!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found. Creating a new airplane.");
        }
    }
}
