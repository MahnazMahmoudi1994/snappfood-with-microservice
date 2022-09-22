package com.kurdestanbootcamp.userservice.common.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String exception) {
        super(exception);
    }
}