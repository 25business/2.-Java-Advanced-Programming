package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        //File f = new File("C:\\java_projects\\ajp_2\\datoteke\\src\\com\\example\\resources\\raven.txt");
        //File f = new File("./src/com/example/resources/raven.txt");
        String resources_path = System.getenv("JAVA_RESOURCES");
        ArrayList<String> redovi = new ArrayList();
        //URL file_path = Program.class.getResource("resources/raven.txt");
        //File f = new File(file_path.getPath());
        File f = new File(resources_path + "\\raven.txt");
        System.out.println(f.getAbsolutePath());
        if(f.exists()) {
            Scanner reader = new Scanner(f);
            reader.useDelimiter("\\n");
            while(reader.hasNext()) {
                redovi.add(reader.next());
            }
        } else {
            System.err.println("File not found on address: " + f.getAbsolutePath());
        }
        int count_nevermore = 0;
        for(String red : redovi) {
            String[] podela = red.split(" ");
            for(String rec : podela) {
                if(rec.toLowerCase().indexOf("nevermore") > -1) {
                    count_nevermore++;
                }
            }
        }
        System.out.println("Count nevermore: " + count_nevermore);
    }
}
