package com.accounts.JsonAPI;
import com.accounts.Enums.MainEnum;
import com.accounts.FileAPI.DirectoryManager;

public class JsonParser {
    public Vagon [] getAllVagons(){
        String vagonPaths = MainEnum.MAIN_JSON_PATH.toString();

        DirectoryManager directoryManager = new DirectoryManager();

        String [] vagonFiles = directoryManager.getAllFilesOfDirectory(vagonPaths);

        for (String str : vagonFiles){
            System.out.println(str);
        }
        return null;
    }

    public static void main (String [] args){
        JsonParser jsonParser = new JsonParser();
        jsonParser.getAllVagons();
    }
}
