package com.example.seatx;

public class Student{
    public String id;
    public String password;
    public String credit;
    public String seatIn;
    public String seatOut;

    public Student(){
    }

    public Student(String id, String password, String credit, String seatIn, String seatOut){
        this.id = id;
        this.password = password;
        this.credit = credit;
        this.seatIn = seatIn;
        this.seatOut = seatOut;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getCredit() {
        return credit;
    }

    public String getSeatIn() {
        return seatIn;
    }

    public String getSeatOut() {
        return seatOut;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setSeatIn(String seatIn) {
        this.seatIn = seatIn;
    }

    public void setSeatOut(String seatOut) {
        this.seatOut = seatOut;
    }
}
