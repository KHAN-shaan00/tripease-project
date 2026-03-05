package com.example.tripease.exception;

public class NotAvailableCab extends RuntimeException {
    public NotAvailableCab(String message) {
        super(message);
    }
}
