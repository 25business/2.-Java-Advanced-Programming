package com.company;

import java.time.LocalTime;

class Proces1 extends Thread {
    public void run() {
        while(true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Proces2 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Poruka!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Proces1 p1 = new Proces1();
        p1.start();
        Proces2 p2 = new Proces2();
        p2.start();
    }
}
