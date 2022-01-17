package com.codegym;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
        int choice = -1;
        HotelManagement hotelManagement = new HotelManagement();
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 6) {
                System.out.println("Menu chỉ có từ 1 => 5");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị thông tin khách thuê phòng");
                    hotelManagement.displayAllHotels();
                    if (hotelManagement.getHotels().size()==0){
                        System.out.println("Không có khách hàng nào để hiển thị!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("----Thêm khách thuê phòng----");
                    System.out.println("Nhập vị trí muốn thêm: ");
                    int index = scanner.nextInt();
                    if ((index - 1) < 0 || (index - 1) > hotelManagement.getHotels().size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Hotel newHotel = inputNewHotel();
                        hotelManagement.addNewHotel(newHotel);
                        System.out.println("Đã thêm khách thành công!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("----Xóa khách thuê phòng----");
                    System.out.println("Nhập vị trí muốn xóa: ");
                    int index = scanner.nextInt();
                    if ((index - 1) < 0 || (index - 1) > hotelManagement.getHotels().size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        hotelManagement.removeHotel(index-1);
                        System.out.println("Đã xóa khách thành công!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Cập nhật thông tin khách hàng----");
                    System.out.println("Nhập vị trí muốn cập nhật: ");
                    int index = scanner.nextInt();
                    if ((index - 1) < 0 || (index - 1) > hotelManagement.getHotels().size()) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Hotel newHotel = inputNewHotel();
                        hotelManagement.updateHotel(index-1, newHotel);
                        System.out.println("Đã cập nhật thôn tin khách thành công!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("----Tìm thông tin khách hàng qua CMND----");
                    System.out.println("Nhập CMND của khách: ");
                    scanner.nextLine();
                    String indentity = scanner.nextLine();
                    int index = hotelManagement.findIndentityCustomer(indentity);
                    if (index == -1){
                        System.out.println("Không tìm thấy khách có CMND: "+ indentity);
                    } else {
                        System.out.println(hotelManagement.getHotels().get(index));
                    }
                    break;
                }
                case 6: {
                    System.out.println("----Tính tiền cho khách----");
                    System.out.println("Nhập CMND của khách: ");
                    scanner.nextLine();
                    String indentity = scanner.nextLine();
                    int index = hotelManagement.findIndentityCustomer(indentity);
                    if (index == -1){
                        System.out.println("Không tìm thấy khách có CMND: "+ indentity);
                    } else {
                        double payMoney = hotelManagement.payMoney(indentity);
                        System.out.println("Số tiền khách phải trả là: "+ payMoney+"(VND)");
                    }

                    break;
                }
            }
        } while (choice != 0);

    }

    public static void menu() {
        System.out.println("----MENU QUẢN LÝ KHÁCH SẠN----");
        System.out.println("1. Hiển thị thông tin của khách thuê phòng ");
        System.out.println("2. Thêm khách thuê phòng ");
        System.out.println("3. Xóa khách thuê phòng ");
        System.out.println("4. Cập nhật thông tin khách hàng");
        System.out.println("5. Tìm thông tin khách hàng qua CMND");
        System.out.println("6. Tính tiền cho khách. ");
        System.out.println("7. Thoát. ");

    }


    public static Hotel inputNewHotel() {
        scanner.nextLine();
        System.out.println("Nhập họ và tên của khách: ");
        String newName = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh của khách: ");
        String newBirth = scanner.nextLine();
        System.out.println("Nhập CMND của khách: ");
        String newCMND = scanner.nextLine();
        System.out.println("Nhập số ngày thuê trọ: ");
        int newDate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập loại phòng thuê: ");
        String newRoom = scanner.nextLine();
        System.out.println("Nhập giá phòng: ");
        double newPrice = scanner.nextDouble();
        return new Hotel(newDate, newRoom, newPrice, new Person(newName, newBirth, newCMND));
    }


}
