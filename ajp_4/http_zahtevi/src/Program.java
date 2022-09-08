import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Program {

    public static HttpResponse<String> get_response(URI uri) throws IOException, InterruptedException {
        Duration timeout = Duration.of(30, ChronoUnit.SECONDS);
        HttpRequest zahtev = HttpRequest.newBuilder(uri).GET().timeout(timeout).build();
        HttpClient klijent = HttpClient.newHttpClient();
        HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
        return odgovor;
    }

    public static void main(String[] args) {
        try {
            /*
            URI adresa = new URI("https://www.cl.cam.ac.uk/~mgk25/ucs/examples/UTF-8-demo.txt");
            Duration timeout = Duration.of(30, ChronoUnit.SECONDS);
            HttpRequest zahtev = HttpRequest.newBuilder(adresa).GET().timeout(timeout).build();
            HttpClient klijent = HttpClient.newHttpClient();
            HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + odgovor.statusCode());
            System.out.println(odgovor.body());
             */
            Scanner input = new Scanner(System.in);
            System.out.println("Unesite naziv lokacije:");
            String lokacija = input.nextLine();
            String url_grad = "https://www.metaweather.com/api/location/search/?query=" + lokacija;
            url_grad = url_grad.replace(" ","+");
            URI adresa_grad = new URI(url_grad);
            HttpResponse<String> odgovor_grad = get_response(adresa_grad);
            Gson gson = new Gson();
            Type gradType = new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType();
            ArrayList<HashMap<String,Object>> podaci_grad = gson.fromJson(odgovor_grad.body(),gradType);
            System.out.println("Rezultati gradova za naziv: " + lokacija);
            for(HashMap<String, Object> podatak: podaci_grad) {
                System.out.printf("[%.0f] %s\n", podatak.get("woeid"), podatak.get("title"));
            }
            System.out.println("Unesite ID grada: ");
            int woeid = Integer.parseInt(input.nextLine());
            URI adresa_vreme = new URI("https://www.metaweather.com/api/location/" + woeid + "/");
            HttpResponse<String> odgovor_vreme = get_response(adresa_vreme);
            Type vremeType = new TypeToken<HashMap<String, Object>>(){}.getType();
            HashMap<String, Object> podaci_vreme = gson.fromJson(odgovor_vreme.body(), vremeType);
            ArrayList<Object> prognoza = (ArrayList)podaci_vreme.get("consolidated_weather");
            LinkedTreeMap<String,Object> bbc_rezultat = (LinkedTreeMap)prognoza.get(0);
            System.out.println("Tip vremena: " + bbc_rezultat.get("weather_state_name"));
            System.out.println("Trenutna temperatura: " + bbc_rezultat.get("the_temp"));
            System.out.println("Pritisak: " + bbc_rezultat.get("air_pressure"));
            System.out.println("Vlaznost: " + bbc_rezultat.get("humidity"));

        }catch(URISyntaxException ex) {
            ex.printStackTrace();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
