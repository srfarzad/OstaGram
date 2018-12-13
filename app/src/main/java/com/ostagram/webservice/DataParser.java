package com.ostagram.webservice;

import com.ostagram.models.Images;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static List<Images> getImages(String data) throws Exception{

        JSONArray array = new JSONArray(data);

        List<Images> imagesList = new ArrayList<>();


        for(int i = 0 ; i<array.length() ; i++) {

            JSONObject e = array.getJSONObject(i);

            String ax = e.getString("img");


            Images images = new Images();
            images.setImg(ax);

            imagesList.add(images);

        }


        return imagesList;

    }

}
