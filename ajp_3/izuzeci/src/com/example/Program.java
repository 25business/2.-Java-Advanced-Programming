package com.example;
import java.util.Scanner;
import com.example.exceptions.NedozvoljenaOpcija;
import com.example.exceptions.TackaUmestoZareza;

public class Program {
    static Scanner input = new Scanner(System.in);

    public static String izbor_opcije() {
        System.out.println("Unesite operaciju (+,-,*,/,**) ili Q za izlaz");
        return input.nextLine();
    }

    public static double kalkulator(String operacija) throws TackaUmestoZareza {
        System.out.println("Unesite prvi broj: ");
        String input_prvi = input.nextLine();
        if(input_prvi.indexOf(",") > -1) {
            throw new TackaUmestoZareza();
        }
        double prvi = Double.parseDouble(input_prvi);
        System.out.println("Unesite drugi broj: ");
        String input_drugi = input.nextLine();
        if(input_drugi.indexOf(",") > -1) {
            throw new TackaUmestoZareza();
        }
        double drugi = Double.parseDouble(input_drugi);

        if(operacija.equals("+")) {
            return prvi + drugi;
        } else if(operacija.equals("-")) {
            return prvi - drugi;
        } else if(operacija.equals("*")) {
            return prvi * drugi;
        } else if(operacija.equals("/")) {
            return prvi / drugi;
        } else {
            return Math.pow(prvi,drugi);
        }
    }

    public static boolean validna_opcija(String opcija) throws NedozvoljenaOpcija {
        String[] opcije = {"+","-","*","/","**","Q","q"};
        boolean validna = false;
        for(String op : opcije) {
            if(op.equals(opcija)) {
                validna = true;
                break;
            }
        }
        if(validna == false) {
            // baciti nas izuzetak
            throw new NedozvoljenaOpcija();
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            while(true) {
                try {
                    String opcija = izbor_opcije();
                    validna_opcija(opcija);

                    if(opcija.toUpperCase().equals("Q")) {
                        break;
                    } else {
                       double rezultat = kalkulator(opcija);
                        System.out.println("Rezultat: " + rezultat);
                    }


                } catch(NedozvoljenaOpcija ex) {
                    System.err.println(ex.getMessage());
                } catch(NumberFormatException ex) {
                    System.err.println("Vrednost mora biti broj.");
                } catch(TackaUmestoZareza ex) {
                    System.err.println(ex.getMessage());
                }
            }

        } catch(Exception ex) {
            System.err.println("-- Nepredvidjena greska --");
            ex.printStackTrace();
        }
    }
}
