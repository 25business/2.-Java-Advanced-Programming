package com.example.exceptions;

public class NedozvoljenaOpcija extends Exception {

    public NedozvoljenaOpcija() {
        super("Opcija treba biti +,-,*,/,** ili q/Q.");
    }
}
