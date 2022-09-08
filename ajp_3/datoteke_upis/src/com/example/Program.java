package com.example;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Program {
    public static void main(String[] args) {
        try {
            String resources = System.getenv("JAVA_RESOURCES");
            String datoteka = resources + "\\ajp3_datoteka.txt";
            File f = new File(datoteka);
            f.createNewFile();

            FileWriter writer = new FileWriter(f, true);
            writer.write("Test 1234!");
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
