package com.codegym;

import java.util.ArrayList;

public class HotelManagement {
    private ArrayList<Hotel> hotels;

    public HotelManagement() {
        this.hotels = new ArrayList<>();
    }

    public HotelManagement(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    //thêm khách thuê phòng
    public void addNewHotel(Hotel newHotel) {
        hotels.add(newHotel);
    }

    //hiển thị toàn bộ khách thuê phòng
    public void displayAllHotels() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ". " + hotels.get(i));
        }
    }
    //Xóa khách thuê phòng
    public void removeHotel(int index){
        hotels.remove(index);
    }
    //cập nhật thông tin khách hàng
    public void updateHotel(int index, Hotel newHotel){
        hotels.set(index,newHotel);
    }
    //tìm thông tin của khách theo CMND
    public int findIndentityCustomer(String indentity){
        int index = -1;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getPerson().getindentity().equals(indentity)){
                index = i;
            }
        }
        return index;
    }
    //tính tiền cho khách
    public double payMoney(String indentity){
        int index = findIndentityCustomer(indentity);
        return hotels.get(index).getPrice() * hotels.get(index).getRentsDay();
    }
}

