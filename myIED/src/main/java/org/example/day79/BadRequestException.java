package org.example.day79;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}