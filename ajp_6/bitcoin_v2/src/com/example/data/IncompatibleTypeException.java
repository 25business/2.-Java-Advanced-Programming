package com.example.data;

public class IncompatibleTypeException extends Exception {

    public IncompatibleTypeException(String className, String userClass) {
        super(String.format("Type '%s' is not compatible with '%s'.",
                className, userClass));
    }
}
