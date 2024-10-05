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

    public String[] toStringArray(JSONArray jsArr) {
        String[] res = new String[jsArr.size()];
        for (int i = 0; i < jsArr.size(); i++) {
            res[i] = jsArr.get(i).toString();
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

    public Vagon [] concatVagonArr(Vagon arr1[], Vagon arr2[]){
        Vagon [] res = new Vagon[arr1.length + arr2.length];
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++){
            res[cnt] = arr1[i];
            cnt++;
        }
        for (int i = 0; i < arr2.length; i++){
            res[cnt] = arr2[i];
            cnt++;
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    public JSONArray toJSONArray(ArrayList<String> arr) {
        JSONArray res = new JSONArray();
        for (int i = 0; i < arr.size(); i++) {
            Object objToAdd = (Object) arr.get(i);
            res.add(objToAdd);
        }
        return res;
    }
}
