package com.mycompany.database.exceptions;

public class InvalidAccountNumberException extends RuntimeException {

    public InvalidAccountNumberException(String message) {
        super(message);
    }
}
