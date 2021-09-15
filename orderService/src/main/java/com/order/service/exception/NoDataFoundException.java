package com.order.service.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {

        super(String.format("No order found"));
    }
}