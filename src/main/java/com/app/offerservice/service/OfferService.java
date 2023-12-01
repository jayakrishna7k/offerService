package com.app.offerservice.service;

import com.app.offerservice.exception.OfferAlreadyExistsException;
import com.app.offerservice.exception.OfferNotFoundException;
import com.app.offerservice.jpa.model.Offer;
import com.app.offerservice.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


//business layer
@Component
public class OfferService {
    //In order to serve business logic for an api ,we call repository methods from the service methods
    @Autowired
    private OfferRepository offerRepository;
    public List<Offer> getAllOffers(){
    List<Offer> offers=offerRepository.findAll();
    if(!offers.isEmpty()) {
        return offers;
    }
    else{
        throw new OfferNotFoundException("Offers are not available");
    }
    }

    public List<Offer> getAllOffersByCategory(String category){
        List<Offer> offers=offerRepository.findByCategory(category);
        if(!offers.isEmpty()) {
            return offers;
        }
        else{
            throw new OfferNotFoundException("Offers are not available");
        }
    }

    public Offer save(Offer offer){
        //please check to avoid duplicate offers
        Offer exists=offerRepository.getOfferByName(offer.getName());
        if(exists!=null){
            throw new OfferAlreadyExistsException("Offer already exists with name :"+offer.getName());
        }
        else{
            return offerRepository.save(offer);
        }
    }
    public void deleteOffer(int id){
        offerRepository.deleteById(id);
        //offerRepository.delete();

    }

}
