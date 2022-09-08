package com.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String resources = System.getenv("JAVA_RESOURCES");
            String json_file = resources + "\\ajp3_people.json";
            File f = new File(json_file);
            Scanner reader = new Scanner(f);
            reader.useDelimiter("\\Z");
            String json_string = reader.next();
            reader.close();
            /*
            Person[] people = gson.fromJson(json_string, Person[].class);
            for(Person p : people) {
                System.out.println(p);
            }
             */
            Type tipListe = new TypeToken<ArrayList<Person>>(){}.getType();
            ArrayList<Person> people = gson.fromJson(json_string, tipListe);
            for(Person p : people) {
                System.out.println(p);
            }

            /*people.add(new Person("Jane", "Connelly", 25, true));
            String json_data_save = gson.toJson(people);

            FileWriter writer = new FileWriter(f);
            writer.write(json_data_save);
            writer.close();*/


        } catch(FileNotFoundException ex) {
            System.err.println("Nije pronadjena datoteka!");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
