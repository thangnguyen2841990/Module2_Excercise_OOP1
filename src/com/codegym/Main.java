package com.codegym;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Khai báo mảng human
        Person[] persons = new Person[5];
        persons[0] = new Person(5, "VIP", 1000000, "Nguyễn Toàn Thắng", "28/04/1990", "032871849");
        persons[1] = new Person(6, "VIP", 1000000, "Trương Hùng Cướng", "08/04/1999", "044871959");
        persons[2] = new Person(7, "Bình dân", 200000, "Mạch Thọ Tuấn Cướng", "25/06/2003", "052871866");
        persons[3] = new Person(8, "Đẹp", 500000, "Lâm Văn Thủy", "22/07/1992", "014871163");
        persons[4] = new Person(3, "VIP", 1000000, "Mai Tiến Việt", "29/06/1991", "019871099");
        menu();
        int choice;
        do {
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 5) {
                System.out.println("Menu chỉ có từ 1 => 5");
            }
            switch (choice) {
                case 1: {
                    System.out.println("----Hiển thị thông tin khách trọ----");
                    showAllPerson(persons);
                    break;
                }
                case 2: {
                    System.out.println("----Thêm khách trọ----");
                    System.out.println("Nhập vị trí muốn thêm: ");
                    int index = scanner.nextInt();
                    if (index < 0 || index > persons.length) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        Person newPerson = inputPerson();
                        persons = addNewPerson(persons, index, newPerson);
                    }
                    break;
                }
                case 3: {
                    System.out.println("----Xóa khách trọ----");
                    System.out.println("Nhập vị trí muốn xóa: ");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= persons.length) {
                        System.out.println("Vị trí không hợp lệ");
                    } else {
                        persons = deletePerson(persons, index);
                    }
                    break;
                }
                case 4: {
                    System.out.println("----Tính tiền cho khách----");
                    scanner.nextLine();
                    System.out.println("Nhập số CMND của khách: ");
                    String cmnd = scanner.nextLine();
                    int index = findCMND(persons, cmnd);
                    if (index == -1) {
                        System.out.println("Không có khách hàng này");
                    } else {

                        double sumMoney = operatorMoney(persons, index);
                        System.out.println(persons[index]);
                        System.out.println("Số tiền khách phải trả là: " + sumMoney + "(VND)");
                    }
                }
            }
        } while (choice != 0);

    }

    public static void menu() {
        System.out.println("Menu: ");
        System.out.println("1. Thông tin của khách trọ ");
        System.out.println("2. Thêm khách trọ ");
        System.out.println("3. Xóa khách trọ ");
        System.out.println("4. Tính tiền cho khách ");
        System.out.println("5. Thoát. ");
    }

    public static void showAllPerson(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            System.out.println((i + 1) + ". " + persons[i]);
        }
    }

    public static Person inputPerson() {
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
        return new Person(newDate, newRoom, newPrice, newName, newBirth, newCMND);
    }

    public static Person[] addNewPerson(Person[] persons, int index, Person newPerson) {
        Person[] newPersons = new Person[persons.length + 1];
        for (int i = 0; i < newPersons.length; i++) {
            if (i < index) {
                newPersons[i] = persons[i];
            } else if (i == index) {
                newPersons[i] = newPerson;
            } else {
                newPersons[i] = persons[i - 1];
            }
        }
        return newPersons;
    }

    public static Person[] deletePerson(Person[] persons, int index) {
        Person[] newPersons = new Person[persons.length - 1];
        for (int i = 0; i < newPersons.length; i++) {
            if (i < index) {
                newPersons[i] = persons[i];
            } else {
                newPersons[i] = persons[i + 1];
            }
        }
        return newPersons;
    }

    public static int findCMND(Person[] persons, String cmnd) {
        int index = -1;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCmnd().equals(cmnd)) {
                index = i;
            }
        }
        return index;
    }

    public static double operatorMoney(Person[] persons, int index) {
        double sumMoney = 0;
        sumMoney = persons[index].getRoomRates() * persons[index].getDateOfRental();
        return sumMoney;
    }

}
