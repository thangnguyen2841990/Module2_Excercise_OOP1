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
                    hotelManagement.displayAllCustomer();
                    break;
                }
                case 2: {
                    System.out.println("----Thêm khách thuê phòng----");
                    System.out.println("Nhập vị trí muốn thêm: ");
                    int index = scanner.nextInt();
                    if ((index - 1) < 0 || (index - 1) > hotelManagement.customers.length) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Hotel newPerson = inputPerson();
                        hotelManagement.addNewCustomer(index - 1, newPerson);
                    }
                    break;
                }
                case 3: {
                    System.out.println("----Xóa khách thuê phòng----");
                    System.out.println("Nhập vị trí muốn xóa: ");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= hotelManagement.customers.length) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        hotelManagement.removeCustomer(index - 1);
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Cập nhật thông tin khách hàng----");
                    System.out.println("Nhập vị trí muốn cập nhật: ");
                    int index = scanner.nextInt();
                    Hotel newCustomer = inputPerson();
                    hotelManagement.updateCustomer(index - 1, newCustomer);
                    break;
                }
                case 5: {
                    System.out.println("----Tính tiền cho khách----");
                    scanner.nextLine();
                    System.out.println("Nhập CMND của khách: ");
                    String cmnd = scanner.nextLine();
                    double money = hotelManagement.payMoney(cmnd);
                    System.out.println("Số tiền khách phải trả là: " + money);
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
        System.out.println("5. Tính tiền cho khách. ");
        System.out.println("6. Thoát. ");

    }


    public static Hotel inputPerson() {
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
