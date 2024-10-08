package com.accounts.JsonAPI;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.accounts.FileAPI.FileManager;

public class JsonParser {

    public Vagon[] getAllVagons() throws ParseException, IOException {
        Vagon [] res = {};
        JsonIO jsonIO = new JsonIO();
        Typetransfer TT = new Typetransfer();
        String[] numbers = jsonIO.getHeadFileNumbersString();

        for (String str : numbers) {
            Vagon [] addArr = getVagonsOfFile(str);
            res = TT.concatVagonArr(res, addArr);
        }
        return res;
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
