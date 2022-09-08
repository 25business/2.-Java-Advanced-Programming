package com.example.coindesk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class CoinDeskHTTP {
    static String COINDESK_ENDPOINT = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public static HashMap<String, Object> get_response_data() {
        try {
            URI konverzija_url =
                    new URI(COINDESK_ENDPOINT);
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
