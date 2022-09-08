package com.example;

public class Program {
    public static void main(String[] args) {
        Level nivo = Level.MIDDLE;
        System.out.println(nivo);

        Ranking novi = Ranking.MASTER;
        System.out.println(novi);

        for(Ranking r : Ranking.values()) {
            System.out.println(r);
        }
    }
}
