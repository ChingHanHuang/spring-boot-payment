package com.example.springpractice.controllers;

import com.example.springpractice.models.PaymentDetails;
import com.example.springpractice.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private Logger logger = Logger.getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestHeader String requestId,
                                                      @RequestBody PaymentDetails paymentDetails) {
        paymentDetails.setId(UUID.randomUUID().toString());
        logger.info("Received request with ID " + requestId +
                " ; Payment Amount: " + paymentDetails.getAmount() +
                " ; Payment ID: " + paymentDetails.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(paymentDetails);
    }
}
