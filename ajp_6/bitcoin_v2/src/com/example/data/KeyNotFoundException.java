package com.example.data;

public class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String key) {
        super(String.format("Key '%s' not found!", key));
    }
}
