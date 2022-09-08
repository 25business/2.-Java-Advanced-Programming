import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try {
            URI konverzija_url =
                    new URI("https://api.coindesk.com/v1/bpi/currentprice.json");
            HttpRequest zahtev = HttpRequest.newBuilder(konverzija_url).GET().build();
            HttpClient klijent = HttpClient.newHttpClient();
            HttpResponse<String> odgovor = klijent.send(zahtev, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Type odgovorType = new TypeToken<HashMap<String, Object>>(){}.getType();
            HashMap<String,Object> coindesk_podaci = gson.fromJson(odgovor.body(), odgovorType);
            Map bpi_podaci = (Map)coindesk_podaci.get("bpi");
            Map EUR_podaci = (Map) bpi_podaci.get("EUR");
            double rate_float = (double) EUR_podaci.get("rate_float");
            System.out.println(rate_float);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesite vrednost u eurima:");
            double euros = Double.parseDouble(scanner.nextLine());
            System.out.println(euros / rate_float);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
