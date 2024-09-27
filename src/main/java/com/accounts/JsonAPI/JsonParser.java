package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.accounts.Enums.ModeEnum;
import com.accounts.FileAPI.FileManager;

public class JsonParser {

    public Vagon[] getAllVagons() throws ParseException, IOException {
        ArrayList<Vagon> preRes = new ArrayList<>();
        FileReader file;
        FileManager fileManager = new FileManager();
        Object obj;
        JSONArray employeeList;
        JsonIO jsonIO = new JsonIO();
        int i;
        Typetransfer TT = new Typetransfer();
        JSONParser jsonParser = new JSONParser();
        String[] numbers = jsonIO.getHeadFileNumbersString();

        // System.out.println(numbers);

        for (String str : numbers) { // вывод всех вагонов // рассмотреть интеграцию пофайлового чтения
            // ------------------------------------
            file = fileManager.getFileReader(str, ModeEnum.FILE_IO_MAIN_MODE.toInt());
            obj = jsonParser.parse(file);
            employeeList = (JSONArray) obj;
            for (i = 0; i < employeeList.size(); i++) {
                JSONObject vagon = (JSONObject) employeeList.get(i);
                preRes.add(TT.toVagon(vagon));
            }
            // хорошо бы чтобы это была отдельная функция как следующая
            // в которой собирались бы все массивы в одну кучку
            // -------------------------------------
        }
        return TT.toVagonArray(preRes);
    }

    public Vagon[] getVagonsOfFile(String vagonNumber) throws IOException, ParseException { // вывод вагонов конкретного
                                                                                            // нумеража
        ArrayList<Vagon> preRes = new ArrayList<>();

        FileManager fileManager = new FileManager();
        Typetransfer TT = new Typetransfer();
        JSONParser jsonParser = new JSONParser();
        FileReader vagonFileReader = fileManager.getFileReader(vagonNumber, 1);
        Object obj = jsonParser.parse(vagonFileReader);
        JSONArray employeeList = (JSONArray) obj;
        for (int i = 0; i < employeeList.size(); i++) {
            JSONObject vagon = (JSONObject) employeeList.get(i);
            preRes.add(TT.toVagon(vagon));
        }
        return TT.toVagonArray(preRes);
    }

    public String[][] getAllVagonsString() throws ParseException, IOException { // временная вариация, позже переделать
                                                                                // под номерные списки
        Vagon[] vagons = this.getAllVagons();
        String[][] res = new String[vagons.length][7];
        for (int i = 0; i < vagons.length; i++) {
            res[i] = vagons[i].toStringArray();
        }
        return res;
    }

    public String[][] getVagonsOfFileString(String vagonNumber) throws IOException, ParseException { // получение
                                                                                                     // вагонов на
                                                                                                     // таблицу из
                                                                                                     // конкретного
                                                                                                     // нумеража
        Vagon[] vagons = this.getVagonsOfFile(vagonNumber);
        String[][] res = new String[vagons.length][7];
        for (int i = 0; i < vagons.length; i++) {
            res[i] = vagons[i].toStringArray();
        }
        return res;
    }

    public static void main(String[] args) throws ParseException, IOException {
        JsonParser jsonParser = new JsonParser();
        Vagon[] vagons = jsonParser.getAllVagons();
        for (int i = 0; i < vagons.length; i++) {
            vagons[i].showVagon();
        }
    }
}
