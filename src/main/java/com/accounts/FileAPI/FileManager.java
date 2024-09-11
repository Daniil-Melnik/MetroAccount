package com.accounts.FileAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.accounts.Enums.MainEnum;

public class FileManager {

    public String makeFileName(int vagonNumber) {
        String vagonNumberStr = Integer.toString(vagonNumber);
        String fileName = vagonNumberStr.substring(0, 2) + "xx.json";
        return fileName;
    }

    private void createFile(String fileName) throws IOException {
        File f = new File(fileName);
        f.createNewFile();
    }

    public FileReader getMainFile(int vagonNumber) throws FileNotFoundException {
        FileReader file;
        String fileName = makeFileName(vagonNumber);
        String fullFilename = MainEnum.MAIN_JSON_PATH + fileName;

        try {
            createFile(fullFilename);
        } catch (IOException e) {
            // добавить логи
        }

        file = new FileReader(fullFilename);

        return file;
    }

    // public static void main(String[] args) {
    // FileManager fm = new FileManager();

    // }
}
