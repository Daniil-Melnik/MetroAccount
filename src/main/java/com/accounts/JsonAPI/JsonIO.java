package com.accounts.JsonAPI;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonIO {
    public static void main(String[] args) throws Exception {
        JSONArray jsonObject = (JSONArray) readJsonArray(
                "C:\\Users\\dmelnik\\Desktop\\вм\\MetroAccount\\src\\json\\vagons.json");
        System.out.println(jsonObject);
    }

    public static Object readJsonArray(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;

        return employeeList;
    }

    public static void writeJsonSingle() {

    }
}
