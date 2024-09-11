package com.accounts.FileAPI;

public class FileManager {

    public String makeFileName(int vagonNumber) {
        String fileName = "";
        String vagonNumberStr = Integer.toString(vagonNumber);
        fileName = vagonNumberStr.substring(0, 2) + "xx.json";
        return fileName;
    }

    // public void getMainFile(String fileName) {

    // }

    public static void main(String[] args) {
        FileManager fm = new FileManager();
        System.out.println(fm.makeFileName(6940));
    }
}
