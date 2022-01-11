package com.codegym;

public class Person extends Hotel {
    private String name;
    private String birthday;
    private String cmnd;

    public Person() {
    }

    public Person(String name, String birthday, String cmnd) {
        this.name = name;
        this.birthday = birthday;
        this.cmnd = cmnd;
    }

    public Person(int dateOfRental, String roomType, double roomRates, String name, String birthday, String cmnd) {
        super(dateOfRental, roomType, roomRates);
        this.name = name;
        this.birthday = birthday;
        this.cmnd = cmnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public String toString() {
        return getName()+", "+getBirthday()+", CMND: "+getCmnd()+", "+super.toString();
    }
}
