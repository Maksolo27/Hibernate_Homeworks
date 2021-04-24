package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by maxim on 24.04.2021.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8080/translator?word=ja";
        String jsonObj = proccesRequest(url);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Translation translation = gson.fromJson(jsonObj, Translation.class);
        System.out.println(translation.toString());

    }

    private static String proccesRequest(String urlStr) throws IOException{
        URL url = new URL(urlStr);
        StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}
