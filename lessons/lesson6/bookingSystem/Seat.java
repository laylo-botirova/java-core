package lessons.lesson6.bookingSystem;

import java.io.Serializable;

public class Seat implements Serializable {
    private String seatNumber;
    private String seatClass;
    private boolean isBooked;
    private String passengerName;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isBooked = false;
        this.passengerName = null;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getPassengerName() {
        return passengerName;
    }
    public void book(String name){
        this.isBooked= true;
        this.passengerName= name;
    }

    public void cancelBooking(){
        this.isBooked= false;
        this.passengerName= null;
    }

    public String toString(){
        String status = isBooked ? "booked already. ": "seat's free";
        return seatNumber + "["+seatClass+"] " + status;
    }
}
