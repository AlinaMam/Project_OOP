package org.example.lab2_3_4;

public class DuplicateModelNameException extends Exception{
    private String name;

    public String getName() {
        return name;
    }

    public DuplicateModelNameException(String message, String name) {
        super(message);
        this.name = name;
    }
}
