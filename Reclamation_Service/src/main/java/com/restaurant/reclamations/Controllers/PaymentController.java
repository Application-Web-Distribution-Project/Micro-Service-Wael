package com.restaurant.reclamations.Controllers;

import com.restaurant.reclamations.Services.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-payment-intent-for-commande")
    public ResponseEntity<Map<String, String>> createPaymentIntentForCommande(@RequestBody Map<String, Object> paymentRequest) {
        try {
            Long amount = Long.valueOf(paymentRequest.get("amount").toString());
            String currency = paymentRequest.get("currency").toString();
            String commandeId = paymentRequest.get("commandeId").toString();
            PaymentIntent paymentIntent = paymentService.createPaymentIntent(amount, currency, commandeId);
            Map<String, String> response = new HashMap<>();
            response.put("clientSecret", paymentIntent.getClientSecret());
            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/update-payment-status")
    public ResponseEntity<Void> updatePaymentStatus(@RequestBody Map<String, String> paymentStatusRequest) {
        String paymentIntentId = paymentStatusRequest.get("paymentIntentId");
        String status = paymentStatusRequest.get("status");
        paymentService.updatePaymentStatus(paymentIntentId, status);
        return ResponseEntity.ok().build();
    }
}