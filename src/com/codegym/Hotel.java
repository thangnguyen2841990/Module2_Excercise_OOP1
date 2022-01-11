package com.codegym;

public class Hotel {
    private int dateOfRental;
    private String roomType;
    private double roomRates;

    public Hotel() {
    }

    public Hotel(int dateOfRental, String roomType, double roomRates) {
        this.dateOfRental = dateOfRental;
        this.roomType = roomType;
        this.roomRates = roomRates;
    }

    public int getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(int dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getRoomRates() {
        return roomRates;
    }

    public void setRoomRates(double roomRates) {
        this.roomRates = roomRates;
    }

    @Override
    public String toString() {
        return "Số ngày trọ: "+ getDateOfRental()+", Loại phòng: "+ getRoomType()+", giá phòng: "+getRoomRates()+"/ngày";
    }
}
