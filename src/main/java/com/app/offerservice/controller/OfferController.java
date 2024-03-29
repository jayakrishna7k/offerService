package com.app.offerservice.controller;

import com.app.offerservice.jpa.model.Offer;
import com.app.offerservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/app/offer")
//presentation layer
public class OfferController {
    @Autowired
    private OfferService offerService;

    //This class contains rest apis
    //In order to serve business logic for an api ,we call service methods from the controller methods as shown in line number 29 or 34 etc.
    @GetMapping("/say/welcome")
    public ResponseEntity<?> sayWelcome() {
        return new ResponseEntity<>("Hi Indupriya and Vyshnavi ,welcome to new spring boot session", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOffers(){

        return new ResponseEntity<>(offerService.getAllOffers(),HttpStatus.OK);
    }
    @GetMapping("/all/category")
    public ResponseEntity<?> getAllOffers(@RequestParam(name="category") String category){

        return new ResponseEntity<>(offerService.getAllOffersByCategory(category),HttpStatus.OK);
    }

    //path variable examle
    @GetMapping("/{category}")
    public ResponseEntity<?> getOfferByOfferName(@PathVariable(name="category") String category){

        return new ResponseEntity<>(offerService.getAllOffersByCategory(category),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveOffer(@RequestBody Offer offer){

        return new ResponseEntity<>(offerService.save(offer),HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyOffer(@RequestBody Offer offer){

        return new ResponseEntity<>(offerService.modify(offer),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOffer(@RequestParam(name="offerId") String offerId){
        offerService.deleteOffer(Integer.valueOf(offerId));
        return new ResponseEntity<>("Deleted succesfully",HttpStatus.OK);
    }

}
