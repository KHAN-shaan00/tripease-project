package com.example.tripease.exception;

public class customerNotFoundException extends RuntimeException {
    public customerNotFoundException(String message) {
        super(message);
    }
}
