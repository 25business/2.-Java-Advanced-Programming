import java.time.*;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        //ZoneId zona = ZoneId.systemDefault();
        //System.out.println(zona);

        //Clock c1 = Clock.systemUTC();
        //Clock c2 = Clock.systemDefaultZone();
        //System.out.println(c1.instant());
        //System.out.println(c2.instant());

        /*
        Instant trenutak = Instant.now();
        System.out.println(trenutak);

        Instant proslost = Instant.parse("2020-11-09T16:49:08Z");
        System.out.println(proslost);
        System.out.println(trenutak.isAfter(proslost));
        System.out.println(proslost.until(trenutak, ChronoUnit.DAYS));
        */

        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy.");

        LocalDate danas = LocalDate.now();
        System.out.println(danas);
        LocalTime vreme = LocalTime.now();
        System.out.println(vreme);
        LocalDateTime trenutno = LocalDateTime.now();
        System.out.println(trenutno.format(dtf));

        LocalDateTime trenutno_tokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(trenutno_tokyo);

        LocalDateTime proslost = LocalDateTime.parse("12:35:00 10.12.2015.", dtf);
        System.out.println(proslost);

        long razlika = ChronoUnit.YEARS.between(proslost, trenutno);
        System.out.println(razlika);
        */
        //Prikazati trenutno vreme u Los Angeles, London, Moscow, Tokyo

        LocalTime trenutno_la = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        LocalTime trenutno_london = LocalTime.now(ZoneId.of("Europe/London"));
        LocalTime trenutno_moscow = LocalTime.now(ZoneId.of("Europe/Moscow"));
        LocalTime trenutno_tokyo = LocalTime.now(ZoneId.of("Asia/Tokyo"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a");
        System.out.printf("""
                Los Angeles: %s
                London: %s
                Moscow: %s
                Tokyo: %s""",trenutno_la.format(dtf), trenutno_london.format(dtf), trenutno_moscow.format(dtf), trenutno_tokyo.format(dtf));
    }
}
