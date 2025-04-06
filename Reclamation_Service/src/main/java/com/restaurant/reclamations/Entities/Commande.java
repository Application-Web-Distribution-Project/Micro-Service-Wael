package com.restaurant.reclamations.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "commandes")
public class Commande {
    @Id
    private String id;
    private LocalDateTime dateCommande = LocalDateTime.now();
    private String status;
    private String userId;
    private List<String> menuIds;
    private String paymentStatus; // "PENDING", "PAID", "FAILED"
    private String paymentIntentId;
}