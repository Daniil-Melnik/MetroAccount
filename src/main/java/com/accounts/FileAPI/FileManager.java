package com.accounts.FileAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;

import com.accounts.Enums.MainEnum;

public class FileManager {

    public String makeFileName(String vagonNumber) {
        String fileName = vagonNumber.substring(0, 2) + "xx.json";
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

    public FileReader getFileReader(String vagonNumber, int mode) throws FileNotFoundException {
        FileReader file;
        String fileName = makeFileName(vagonNumber);
        String fullFilename = "";

        switch (mode) {
            case 1:
                fullFilename = MainEnum.MAIN_JSON_PATH + fileName;
                break;
            case 2:
                fullFilename = MainEnum.VAGON_TIME_JSON_PATH + fileName;
                break;

            case 3:
                fullFilename = MainEnum.HEAD_JSON_PATH.toString();
            default:
                break;
        }
        if (mode == 1 || mode == 2) {
            try {
                createFile(fullFilename);
            } catch (IOException e) {
                // добавить логи
                System.out.println("Не заполнился файл");
            }
        }

        file = new FileReader(fullFilename);

        return file;
    }

    public FileWriter getFileWriter(String vagonNumber, int mode) throws IOException {
        FileWriter file;
        String fileName = makeFileName(vagonNumber);
        String fullFilename = "";

        switch (mode) {
            case 1:
                fullFilename = MainEnum.MAIN_JSON_PATH + fileName;
                break;
            case 2:
                fullFilename = MainEnum.VAGON_TIME_JSON_PATH + fileName;
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
