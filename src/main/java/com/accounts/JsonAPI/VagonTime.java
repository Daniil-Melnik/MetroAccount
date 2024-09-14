package com.accounts.JsonAPI;

public class VagonTime {
    private String number;
    private int time;

    public VagonTime(String number, int time) {
        this.time = time;
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }
}
