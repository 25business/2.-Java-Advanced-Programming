package com.example;

public class Printer implements Displayable {
    @Override
    public void display() {
        System.out.println("Printing text!");
    }
}
