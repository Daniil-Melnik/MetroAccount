package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.accounts.Enums.MainEnum;
import com.accounts.Enums.ModeEnum;
import com.accounts.FileAPI.FileManager;

public class JsonIO {
    public static void main(String[] args) throws Exception {
        JsonIO.updateHead("0000");
    }

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

    public static JSONObject readJsonHead() {
        FileManager fileManager = new FileManager();
        try (FileReader reader = fileManager.getFileReader("", 3)) {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONObject employeeObject = (JSONObject) obj;

            return employeeObject;
        } catch (IOException | ParseException e) {
            // что-то в логи
            System.out.println("Не удалось прочитать головной файл");
            return null;
        }
    }

    public String[] getHeadFileNumbersString() {
        Typetransfer TT = new Typetransfer();
        JSONObject obj = readJsonHead();
        JSONArray numbers = (JSONArray) obj.get("numbers");
        return TT.toStringArray(numbers);
    }

    private static boolean isInList(String numberXX, JSONArray arr) {
        boolean res = true;
        int i = 0;
        while (res && i < arr.size()) {
            if (arr.get(i).toString().equals(numberXX)) {
                res = false;
            }
            i++;
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    private static void updateHead(String vagonNumber) {
        JSONObject headFile = readJsonHead();
        System.out.println(headFile);
        JSONArray numbers = (JSONArray) headFile.get("numbers");
        String numberXX = vagonNumber.substring(0, 2) + "xx";
        if (isInList(numberXX, numbers)) {
            numbers.add(numberXX);
        }
        headFile.put("numbers", numbers);

        try (FileWriter file = new FileWriter(MainEnum.HEAD_JSON_PATH + "app-head.json")) { // заменить на что-то
                                                                                            // нормальное
            file.write(headFile.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
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
            updateHead(addVagon.getNumber());
        } catch (Exception e) {
            // что-то в логи
            System.out.println("Не удалось записать в файл");
        }

    }

    private static int getLastTime(JSONArray numberTimeList, String vagonNumber) {
        String number;
        int time = 0;
        int cnt = 0;

        while ((time == 0) && (cnt < numberTimeList.size())) {
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
