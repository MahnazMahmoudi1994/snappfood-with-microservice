package com.kurdestanbootcamp.addressservice.common.exception;

public class NotFoundException  extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}