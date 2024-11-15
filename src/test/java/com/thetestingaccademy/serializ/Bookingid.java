package com.thetestingaccademy.serializ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookingid {

    @SerializedName("bookingid")
    @Expose
    public Integer bookingid;
    @SerializedName("booking")
    @Expose
    public Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
