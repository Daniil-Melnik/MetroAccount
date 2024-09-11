package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.accounts.FileAPI.FileManager;

public class JsonIO {
    public static void main(String[] args) throws Exception {
        JSONArray jsonObject = (JSONArray) readJsonArray(
                6940);
        System.out.println(jsonObject);
    }

    public static JSONArray readJsonArray(int vagonNumber) throws Exception {
        // FileReader reader = new FileReader(filename);
        FileManager fileManager = new FileManager();
        FileReader reader = fileManager.getMainFile(vagonNumber);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;

        // System.out.println(employeeList.get(0));
        // System.out.println(employeeList.get(1));
        return employeeList;
    }

    @SuppressWarnings("unchecked")
    public static void writeJsonSingle(Vagon addVagon) throws Exception {

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

        try (FileWriter file = new FileWriter(
                "src/json/vagons3.json")) {
            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
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
