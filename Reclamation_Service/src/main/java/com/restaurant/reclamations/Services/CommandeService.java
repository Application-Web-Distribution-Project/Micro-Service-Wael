package com.restaurant.reclamations.Services;

import com.restaurant.reclamations.Entities.Commande;
import com.restaurant.reclamations.Repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(String id) {
        return commandeRepository.findById(id);
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(String id, Commande commandeDetails) {
        return commandeRepository.findById(id).map(commande -> {
            commande.setStatus(commandeDetails.getStatus());
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public void deleteCommande(String id) {
        commandeRepository.deleteById(id);
    }
}