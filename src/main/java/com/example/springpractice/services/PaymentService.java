package com.example.springpractice.services;

import com.example.springpractice.exceptions.NotEnoughMoneyException;
import com.example.springpractice.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
