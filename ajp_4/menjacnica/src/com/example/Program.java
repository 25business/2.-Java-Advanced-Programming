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
        System.out.println("Unesite novcanu vrednost: ");
        double vrednost = Double.parseDouble(input.nextLine());
        System.out.println("Unesite valutu vrednosti: ");
        String valuta_osnovna = input.nextLine();
        System.out.println("Unesite valutu u koju konvertujete: ");
        String valuta_konverzija = input.nextLine();
        try {
            URI konverzija_url =
            new URI("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" +
                    valuta_osnovna.toLowerCase() + "/" + valuta_konverzija.toLowerCase() + ".json");
            HttpRequest zahtev = HttpRequest.newBuilder(konverzija_url).GET().build();
            HttpClient klijent = HttpClient.newHttpClient();
            HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Type odgovorType = new TypeToken<HashMap<String, Object>>(){}.getType();
            HashMap<String,Object> vrednost_valute = gson.fromJson(odgovor.body(), odgovorType);
            double koeficijent = (double) vrednost_valute.get(valuta_konverzija.toLowerCase());
            System.out.printf("%.2f %s => %.2f %s", vrednost, valuta_osnovna, vrednost * koeficijent,
                    valuta_konverzija);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
