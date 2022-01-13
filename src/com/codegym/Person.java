package com.codegym;

public class Person {
    private String name;
    private String birthday;
    private String indentity;

    public Person() {
    }

    public Person(String name, String birthday, String indentity) {
        this.name = name;
        this.birthday = birthday;
        this.indentity = indentity;
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

    public String getindentity() {
        return indentity;
    }

    public void setindentity(String indentity) {
        this.indentity = indentity;
    }

    @Override
    public String toString() {
        return "Họ và tên: "+ getName()+", Ngày sinh: "+getBirthday()+", CMND: "+getindentity();
    }
}
