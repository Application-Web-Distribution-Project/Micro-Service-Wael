package com.restaurant.reclamations.Repositories;


import com.restaurant.reclamations.Entities.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {
    List<Commande> findByUserId(String userId); // Trouver les commandes d’un utilisateur
}