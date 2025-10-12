package lessons.lesson7;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Duration;

public class Seat implements Serializable {
    private String seatNumber;
    private String seatClass;
    private String status;
    private String passengerName;
    private LocalDateTime bookingTime;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.status = "FREE";
        this.passengerName = null;
        this.bookingTime = null;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public String getStatus() {
        return status;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void book(String name) {
        this.status = "BOOKED";
        this.passengerName = name;
        this.bookingTime = LocalDateTime.now();
    }

    public void pay() {
        if ("BOOKED".equals(status)) {
            this.status = "PAID";
        }
    }

    public void cancelBooking() {
        this.status = "FREE";
        this.passengerName = null;
        this.bookingTime = null;
    }

    public void checkExpiration() {
        if ("BOOKED".equals(status) && bookingTime != null) {
            Duration duration = Duration.between(bookingTime, LocalDateTime.now());
            if (duration.toMinutes() >= 24) {
                cancelBooking();
            }
        }
    }

    public String toString() {
        String info = seatNumber + " [" + seatClass + "] - ";
        return switch (status) {
            case "FREE" -> info + "Free";
            case "BOOKED" -> info + "Booked by " + passengerName + " at " + bookingTime;
            case "PAID" -> info + "Paid by " + passengerName;
            default -> info + "Unknown status";
        };
    }
}
