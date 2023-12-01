package com.app.offerservice.repository;

import com.app.offerservice.jpa.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Persistance layer
//Repository comunicated with DB throeugh Data Jpa.
@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {

       //Offer findByName(String name);
        @Query(nativeQuery = true,name = "select * from offer where name== name")//jpql query
        Offer getOfferByName(@Param("name") String name);
        List<Offer> findByCategory(String category);


}
