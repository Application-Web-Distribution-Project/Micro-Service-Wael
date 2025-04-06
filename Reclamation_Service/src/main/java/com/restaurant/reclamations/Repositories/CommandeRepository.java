package com.restaurant.reclamations.Repositories;


import com.restaurant.reclamations.Entities.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {
    List<Commande> findByUserId(String userId);
    Optional<Commande> findByPaymentIntentId(String paymentIntentId);
}