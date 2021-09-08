package com.example.seatx;

public class BusDataAdd {
    public String seatNumber;
    public String seatStatus;

    public BusDataAdd() {
    }


    public BusDataAdd(String seatNumber, String seatStatus) {
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

}
