package com.restaurant.reclamations.Services;

import com.restaurant.reclamations.Entities.Commande;
import com.restaurant.reclamations.Repositories.CommandeRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CommandeRepository commandeRepository;

    public PaymentIntent createPaymentIntent(Long amount, String currency, String commandeId) throws StripeException {
        Optional<Commande> optionalCommande = commandeRepository.findById(commandeId);
        if (!optionalCommande.isPresent()) {
            throw new RuntimeException("Commande does not exist");
        }

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount)
                .setCurrency(currency)
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        Commande commande = optionalCommande.get();
        commande.setPaymentIntentId(paymentIntent.getId());
        commande.setPaymentStatus("PENDING");
        commandeRepository.save(commande);

        return paymentIntent;
    }

    public void updatePaymentStatus(String paymentIntentId, String status) {
        Optional<Commande> optionalCommande = commandeRepository.findByPaymentIntentId(paymentIntentId);
        if (optionalCommande.isPresent()) {
            Commande commande = optionalCommande.get();
            commande.setPaymentStatus(status);
            commandeRepository.save(commande);
        }
    }
}