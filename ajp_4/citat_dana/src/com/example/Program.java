package com.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite jezik (en/ru): ");
        String jezik = input.nextLine();
        try {
            URI citat_url =
                    new URI("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=" + jezik);
            HttpRequest zahtev = HttpRequest.newBuilder(citat_url).GET().build();
            HttpClient klijent = HttpClient.newHttpClient();
            HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Type odgovorType = new TypeToken<HashMap<String, Object>>(){}.getType();
            HashMap<String,Object> vrednost_citata = gson.fromJson(odgovor.body(), odgovorType);
            System.out.printf("%s\n    - %s", vrednost_citata.get("quoteText"),
                                vrednost_citata.get("quoteAuthor"));
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
