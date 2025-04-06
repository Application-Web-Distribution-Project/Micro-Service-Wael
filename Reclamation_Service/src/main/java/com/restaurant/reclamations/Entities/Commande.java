package com.restaurant.reclamations.Entities;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "commandes") // Collection MongoDB
public class Commande {
    @Id
    private String id; // ID unique généré par MongoDB
    private LocalDateTime dateCommande = LocalDateTime.now();
    private String status; // "EN_ATTENTE", "EN_COURS", "LIVREE", "ANNULEE"
    private String userId; // ID de l'utilisateur qui passe la commande
    private List<String> menuIds; // Liste des menus commandés
}