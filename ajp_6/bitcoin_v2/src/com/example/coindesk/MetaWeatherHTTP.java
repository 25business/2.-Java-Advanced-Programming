package com.example.coindesk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class MetaWeatherHTTP {
    static String METAWEATHER_ENDPOINT = "https://www.metaweather.com/api/location/2487956/";

    public static HashMap<String, Object> get_response_data() {
        try {
            URI konverzija_url =
                    new URI(METAWEATHER_ENDPOINT);
            HttpRequest zahtev = HttpRequest.newBuilder(konverzija_url).GET().build();
            HttpClient klijent = HttpClient.newHttpClient();
            HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Type odgovorType = new TypeToken<HashMap<String, Object>>() {
            }.getType();
            return gson.fromJson(odgovor.body(), odgovorType);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new HashMap<String, Object>();
        }
    }
}
