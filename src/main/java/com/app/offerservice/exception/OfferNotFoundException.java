package com.app.offerservice.exception;

public class OfferNotFoundException extends RuntimeException{

    public OfferNotFoundException(String message){
     super(message);
    }
}
