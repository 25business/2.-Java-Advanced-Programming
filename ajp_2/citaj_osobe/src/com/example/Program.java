package com.example;
import com.example.osobe.Osoba;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Osoba> osobe = new ArrayList();
        String java_resources = System.getenv("JAVA_RESOURCES");
        File csv_osobe = new File(java_resources + "\\ajp2_osobe.csv");
        if(csv_osobe.exists()) {
            Scanner reader = new Scanner(csv_osobe);
            reader.useDelimiter("\\n");
            while(reader.hasNext()) {
                String red = reader.next();
                String[] podela = red.split(",");
                int id = Integer.parseInt(podela[0]);
                String ime = podela[1];
                String prezime = podela[2];
                int godine = Integer.parseInt(podela[3]);
                Osoba p = new Osoba(id, ime, prezime, godine);
                osobe.add(p);
            }
        } else {
            System.err.println("File not found: " + csv_osobe.getAbsolutePath());
        }

        for(Osoba o : osobe) {
            System.out.println(o);
        }
    }
}
