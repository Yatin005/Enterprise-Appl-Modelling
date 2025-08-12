package com.yatin.spring.finalex;


public class ReservationForm {
    private String firstName;
    private String lastName;
    private int numberOfPassengers;
    private String selectedClass;
    private String phoneNumber;
    private String time;
    private String departingDate;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }
    public String getSelectedClass() { return selectedClass; }
    public void setSelectedClass(String selectedClass) { this.selectedClass = selectedClass; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getDepartingDate() { return departingDate; }
    public void setDepartingDate(String departingDate) { this.departingDate = departingDate; }
}