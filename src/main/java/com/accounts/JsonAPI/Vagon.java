package com.accounts.JsonAPI;

public class Vagon {
    private String number;
    private String type;
    private String line;
    private String date;
    private String time;
    private String factory;
    private String productDate;

    public Vagon(String number, String type, String line, String date, String time, String factory, String productDate) {
        this.number = number;
        this.type = type;
        this.line = line;
        this.date = date;
        this.time = time;
        this.factory = factory;
        this.productDate = productDate;
    }

    public void showVagon(){
        System.out.println(this.getNumber() + " " + this.getDate() + " " + this.getFactory() + " " + this.getLine() + " " + this.getType());
    }

    public void setNumber(String newNumber) {
        number = newNumber;
    }

    public void setType(String newType) {
        type = newType;
    }

    public void setLine(String newLine) {
        line = newLine;
    }

    public void setDate(String newDate) {
        date = newDate;
    }

    public void setTime(String newTime) {
        time = newTime;
    }

    public void setFactory(String newFactory) {
        factory = newFactory;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getLine() {
        return line;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getFactory() {
        return factory;
    }

    public String getProductDate() {
        return productDate;
    }

    public void printVagonInfo() {
        System.out.println(number + " -- " + type + " -- " + line + " -- " + date + " -- " + time + " -- " + factory
                + " -- " + productDate);
    }
}
