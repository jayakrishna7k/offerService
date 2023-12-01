package com.app.offerservice.exception;

public class OfferAlreadyExistsException extends RuntimeException{
    public OfferAlreadyExistsException(String message){
        super(message);
    }
}
