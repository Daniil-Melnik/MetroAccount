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
    // public static void main(String[] args) throws Exception {
    //     JSONArray jsonObject = (JSONArray) readJsonArray(
    //             6940, 1);
    //     System.out.println(jsonObject);
    // }

    public static JSONArray readJsonArray(String vagonNumber, int mode) {
        FileManager fileManager = new FileManager();
        try (FileReader reader = fileManager.getFileReader(vagonNumber, mode)) {
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
                addVagon.getNumber(), ModeEnum.FILE_IO_MAIN_MODE.toInt());
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

    private static int getLastTime(JSONArray numberTimeList, String vagonNumber){
        String number; 
        int time = 0;
        int cnt = 0;

        while ((time == 0) && (cnt < numberTimeList.size())){
            JSONObject obj = (JSONObject) numberTimeList.get(cnt);
            number = obj.get("number").toString();
            time = (number.equals(vagonNumber)) ? Integer.parseInt(obj.get("time").toString()) : 0;
            cnt++;
        }

        return time;
    }

    @SuppressWarnings("unchecked")
    public static void writeJsonSingle(String vagonNumber) throws Exception {
        FileManager fileManager = new FileManager();

        JSONArray numberTimeList = readJsonArray(
                vagonNumber, ModeEnum.FILE_IO_VAGON_TIME_MODE.toInt());

        int time = getLastTime(numberTimeList, vagonNumber);
        

        numberTimeList.removeIf(object -> ((JSONObject) object).get("number").toString().equals(vagonNumber)); // !!!

        VagonTime addVagonTime = new VagonTime(vagonNumber, time + 1); // вставлять колво вместо 1
        JSONObject addObj = new JSONObject();
        addObj.put("number", addVagonTime.getNumber());
        addObj.put("time", addVagonTime.getTime());

        numberTimeList.add(addObj);

        try (FileWriter file = fileManager.getFileWriter(addVagonTime.getNumber(),
                ModeEnum.FILE_IO_VAGON_TIME_MODE.toInt())) {
            file.write(numberTimeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
