package org.example.lab2_3_4_5.exception;

public class NoSuchModelNameException extends Exception{
    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public NoSuchModelNameException(String message, String modelName) {
        super(message);
        this.modelName = modelName;
    }
}
