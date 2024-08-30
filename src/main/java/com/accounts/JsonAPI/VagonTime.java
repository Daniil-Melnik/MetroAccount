package com.accounts.JsonAPI;

public class VagonTime {
    private int number;
    private int time;

    public VagonTime(int number, int time) {
        this.time = time;
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public int getNumber() {
        return number;
    }
}
