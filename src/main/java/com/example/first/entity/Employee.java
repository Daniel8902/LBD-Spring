package com.example.first.entity;

public class Employee {

    private  int id;
    private String firstname;
    private String lastname;
    private int pesel;
    private int phoneNumber;
    private int numberId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }
    public Employee(){}

    public Employee(int id, String firstname, String lastname, int pesel, int phoneNumber, int numberId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.numberId = numberId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pesel=" + pesel +
                ", phoneNumber=" + phoneNumber +
                ", numberId=" + numberId +
                '}';
    }
}
