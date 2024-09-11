package com.accounts.FileAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

import com.accounts.Enums.MainEnum;

public class FileManager {

    public String makeFileName(int vagonNumber) {
        String vagonNumberStr = Integer.toString(vagonNumber);
        String fileName = vagonNumberStr.substring(0, 2) + "xx.json";
        return fileName;
    }

    @SuppressWarnings("resource")
    private void createFile(String fileName) throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            FileWriter writer = new FileWriter(fileName);
            JSONArray employeeList = new JSONArray();

            writer.write(employeeList.toJSONString());
            writer.flush();
        }
    }

    public FileReader getFileReader(int vagonNumber, int mode) throws FileNotFoundException {
        FileReader file;
        String fileName = makeFileName(vagonNumber);
        String fullFilename = "";

        switch (mode) {
            case 1:
                fullFilename = MainEnum.MAIN_JSON_PATH + fileName;
                break;

            default:
                break;
        }

        try {
            createFile(fullFilename);
        } catch (IOException e) {
            // добавить логи
            System.out.println("Не заполнился файл");
        }

        file = new FileReader(fullFilename);

        return file;
    }

    public FileWriter getFileWriter(int vagonNumber, int mode) throws IOException {
        FileWriter file;
        String fileName = makeFileName(vagonNumber);
        String fullFilename = "";

        switch (mode) {
            case 1:
                fullFilename = MainEnum.MAIN_JSON_PATH + fileName;
                break;

            default:
                break;
        }

        file = new FileWriter(fullFilename);

        return file;
    }

    // public static void main(String[] args) {
    // FileManager fm = new FileManager();

    // }
}
