package com.accounts.FileAPI;

import java.io.FileReader;

import com.accounts.Enums.MainEnum;

public class FileManager {

    public String makeFileName(int vagonNumber) {
        String vagonNumberStr = Integer.toString(vagonNumber);
        String fileName = vagonNumberStr.substring(0, 2) + "xx.json";
        return fileName;
    }

    public FileReader getMainFile(int vagonNumber) {
        String fileName = makeFileName(vagonNumber);
        String fullFilename = MainEnum.MAIN_JSON_PATH + fileName;
        System.out.println(fullFilename);
        return null;
    }

    public static void main(String[] args) {
        FileManager fm = new FileManager();
        fm.getMainFile(6940);
    }
}
