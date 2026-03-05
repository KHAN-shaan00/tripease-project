package com.example.tripease.exception;

public class driverNotFound extends RuntimeException {
    public driverNotFound(String message) {
        super(message);
    }
}
