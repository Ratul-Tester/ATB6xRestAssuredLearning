package com.thetestingaccademy.gson.serialization;

public class BookingResponse {
    Integer bookingid;
    Bookingg booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Bookingg getBooking() {
        return booking;
    }

    public void setBooking(Bookingg booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
