package com.kurdestanbootcamp.userservice.common.exception;

public class NotFoundException  extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}