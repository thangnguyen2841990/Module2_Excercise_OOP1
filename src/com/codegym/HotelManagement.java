package com.codegym;

public class HotelManagement {
    Hotel[] customers = new Hotel[0];

    public HotelManagement(Hotel[] customers) {
        this.customers = customers;
    }

    public HotelManagement() {

    }

    public Hotel[] getcustomers() {
        return customers;
    }

    public void setcustomers(Hotel[] customers) {
        this.customers = customers;
    }

    public int size() {
        return this.customers.length;
    }

    public void displayAllCustomer() {
        for (int i = 0; i < customers.length; i++) {
            System.out.println((i + 1) + ". " + customers[i]);
        }
    }

    public void addNewCustomer(int index, Hotel newCustomer) {
        Hotel[] newCustomers = new Hotel[customers.length + 1];
        for (int i = 0; i < newCustomers.length; i++) {
            if (i < index) {
                newCustomers[i] = customers[i];
            } else if (i == index) {
                newCustomers[i] = newCustomer;
            } else {
                newCustomers[i] = customers[i - 1];
            }
        }
        customers = newCustomers;
    }

    public void removeCustomer(int index) {
        Hotel[] newCustomers = new Hotel[customers.length - 1];
        for (int i = 0; i < newCustomers.length; i++) {
            if (i < index) {
                newCustomers[i] = customers[i];
            } else {
                newCustomers[i] = customers[i + 1];
            }
        }
        customers = newCustomers;
    }

    public void updateCustomer(int index, Hotel newCustomer) {
        this.customers[index] = newCustomer;
    }

    public double payMoney(String cmnd) {
        double money = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getPerson().getindentity().equals(cmnd)) {
                money = money + customers[i].getPrice() * customers[i].getRentsDay();
            }
        }
        return money;
    }
}

