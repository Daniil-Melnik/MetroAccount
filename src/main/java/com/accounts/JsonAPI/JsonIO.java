package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.accounts.Enums.ModeEnum;
import com.accounts.FileAPI.FileManager;

public class JsonIO {
    public static void main(String[] args) throws Exception {
        JSONArray jsonObject = (JSONArray) readJsonArray(
                6940);
        System.out.println(jsonObject);
    }

    public static JSONArray readJsonArray(int vagonNumber) {
        FileManager fileManager = new FileManager();
        try (FileReader reader = fileManager.getFileReader(vagonNumber, ModeEnum.FILE_IO_MAIN_MODE.toInt())) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;

            return employeeList;
        } catch (IOException | ParseException e) {
            // что-то в логи
            System.out.println("Не удалось прочитать файл");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static void writeJsonSingle(Vagon addVagon) throws Exception {

        FileManager fileManager = new FileManager();

        JSONObject addVagonObj = new JSONObject();
        addVagonObj.put("number", addVagon.getNumber());
        addVagonObj.put("type", addVagon.getType());
        addVagonObj.put("line", addVagon.getLine());
        addVagonObj.put("date", addVagon.getDate());
        addVagonObj.put("time", addVagon.getTime());
        addVagonObj.put("factory", addVagon.getFactory());
        addVagonObj.put("productDate", addVagon.getProductDate());

        JSONArray employeeList = readJsonArray(
                addVagon.getNumber());
        employeeList.add(addVagonObj);

        try {
            FileWriter writer = fileManager.getFileWriter(addVagon.getNumber(), ModeEnum.FILE_IO_MAIN_MODE.toInt());
            writer.write(employeeList.toJSONString());
            writer.flush();
        } catch (Exception e) {
            // что-то в логи
            System.out.println("Не удалось записать в файл");
        }

    }

    @SuppressWarnings("unchecked")
    public static void writeJsonSingle(VagonTime addVagonTime) throws Exception {
        JSONArray numberTimeList = readJsonArray(
                addVagonTime.getNumber());

        JSONObject addObj = new JSONObject();
        addObj.put("number", addVagonTime.getNumber());
        addObj.put("time", addVagonTime.getTime());

        numberTimeList.add(addObj);

        try (FileWriter file = new FileWriter(
                "src/json/numtime.json")) {
            file.write(numberTimeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
