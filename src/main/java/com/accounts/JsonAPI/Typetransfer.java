package com.accounts.JsonAPI;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Typetransfer {

    public Vagon toVagon(JSONObject obj) {
        Vagon res;
        String number = obj.get("number").toString();
        String type = obj.get("type").toString();
        String line = obj.get("line").toString();
        String date = obj.get("date").toString();
        String time = obj.get("time").toString();
        String factory = obj.get("factory").toString();
        String productDate = obj.get("productDate").toString();
        res = new Vagon(number, type, line, date, time, factory, productDate);
        return res;
    }

    public Vagon[] toVagonArray(ArrayList<Vagon> arrList) {
        Vagon[] res = new Vagon[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            res[i] = arrList.get(i);
        }
        return res;
    }

    public ArrayList<String> toArrayList(JSONArray jsonArr) {
        ArrayList<String> resArr = new ArrayList<>();
        for (int i = 0; i < jsonArr.size(); i++) {
            resArr.add(jsonArr.get(i).toString());
        }
        return resArr;
    }
}
