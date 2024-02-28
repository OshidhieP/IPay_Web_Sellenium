package com.example.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestDataLoader {

    public static JSONObject loadTestData() {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("src/main/resources/testData.json");
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
