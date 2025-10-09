package lessons.lesson6.bookingSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Airplane implements Serializable {
    private List<Seat> seats;

    public Airplane() {
        seats = new ArrayList();
        initSeats();
    }

    public void initSeats() {
        String[] letters = {"A", "B", "C", "D"};
// business logic
        for (int row = 1; row <= 5; row++) {
            for (int i = 0; i < letters.length; i++) {
                seats.add(new Seat(row + letters[i], "Business class"));

            }

        }
        for (int row = 6; row <= 20; row++) {
            for (int i = 0; i < letters.length; i++) {
                seats.add(new Seat(row + letters[i], "Economy class"));

            }

        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat findSeat(String seatNum) {
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = (Seat) seats.get(i);
            if (seat.getSeatNumber().equalsIgnoreCase(seatNum)) return seat;

        }
        return null;
    }

    public void showSeats() {
        System.out.println("business class: ");
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = (Seat) seats.get(i);
            if ("Business class".equals(seat.getSeatClass())) {
                System.out.println(seat);
            }

        }
        System.out.println("Economy class: ");
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = (Seat) seats.get(i);
            if ("Economy class".equals(seat.getSeatClass())) {
                System.out.println(seat);
            }

        }
    }

    public void save(String filename) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(seats);
            System.out.println("seats saved successfully");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void loadSeatsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            seats = (List<Seat>) ois.readObject();
            System.out.println("seats loaded! ");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

