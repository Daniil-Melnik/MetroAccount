package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonIO {
    public static void main(String[] args) throws Exception {
        JSONArray jsonObject = (JSONArray) readJsonArray(
                "C:\\Users\\dmelnik\\Desktop\\вм\\MetroAccount\\src\\json\\vagons.json");
        System.out.println(jsonObject);
    }

    public static JSONArray readJsonArray(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;

        System.out.println(employeeList.get(0));
        System.out.println(employeeList.get(1));
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

        JSONArray employeeList = readJsonArray(
                "C:\\Users\\dmelnik\\Desktop\\вм\\MetroAccount\\src\\json\\vagons3.json");
        employeeList.add(addVagonObj);

        try (FileWriter file = new FileWriter(
                "C:\\Users\\dmelnik\\Desktop\\вм\\MetroAccount\\src\\json\\vagons3.json")) {
            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
