package com.kurdestanbootcamp.categorysuppliersupcategoryservice.common.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String exception) {
        super(exception);
    }
}