package com.accounts.JsonAPI;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.accounts.Enums.MainEnum;
import com.accounts.FileAPI.DirectoryManager;

public class JsonParser {
    public Vagon [] getAllVagons() throws ParseException, IOException{
        ArrayList <Vagon> preRes = new ArrayList<>();
        FileReader file;
        Object obj;
        JSONArray employeeList;
        int i;

        Typetransfer TT = new Typetransfer();

        JSONParser jsonParser = new JSONParser();
        String vagonPaths = MainEnum.MAIN_JSON_PATH.toString();
        DirectoryManager directoryManager = new DirectoryManager();
        String [] vagonFiles = directoryManager.getAllFilesOfDirectory(vagonPaths);

        for (String str : vagonFiles){ // получен список всех файлов, осталось распарсить
            file = new FileReader(str);
            obj = jsonParser.parse(file);
            employeeList = (JSONArray) obj;
            for (i = 0; i < employeeList.size(); i++){
                JSONObject vagon = (JSONObject) employeeList.get(i);
                preRes.add(TT.toVagon(vagon));
            }
        }
        return TT.toVagonArray(preRes);
    }
    
    public static void main (String [] args) throws ParseException, IOException{
        JsonParser jsonParser = new JsonParser();
        Vagon [] vagons = jsonParser.getAllVagons();
        for (int i = 0; i < vagons.length; i++){
            vagons[i].showVagon();
        }        
    }
}
