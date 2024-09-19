package com.accounts.FileAPI;

import java.io.File;
  
import com.accounts.Enums.MainEnum;

public class DirectoryManager {

    public String [] getAllFilesOfDirectory(String dirPath){
        int cnt = 0;
        File dir = new File(dirPath);

        String [] res = new String[dir.listFiles().length];
        for ( File file : dir.listFiles() ){
            if ( file.isFile() ){
                res[cnt] = dirPath + file.getName();
                cnt++;
            }
        }
        return res;
    }

    public static void main (String [] args){
        DirectoryManager directoryManager = new DirectoryManager();
        directoryManager.getAllFilesOfDirectory(MainEnum.MAIN_JSON_PATH.toString());

    }
}
