package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        String request = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=19990302&json";
        String result = perfReq(request);
        Gson gson = new GsonBuilder().create();
        Currency[] currencies = gson.fromJson(result, Currency[].class);
        for (Currency c: currencies) {
            System.out.println(c.toString());
        }

    }
    private static String perfReq(String urlS) throws IOException{
        URL url = new URL(urlS);
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        char[] buf = new char[1000000];

        int r = 0;

        do {
            if((r = br.read(buf)) > 0)
                stringBuilder.append(new String(buf, 0, r));

        }while (r > 0);
        http.disconnect();
        return stringBuilder.toString();
    }


}
