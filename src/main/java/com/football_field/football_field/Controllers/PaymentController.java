package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Servicies.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @CrossOrigin
    @PostMapping
    public Payment createPayment(
            @RequestBody Payment payment,
            @RequestParam Long fieldId,
            @RequestParam int book_hours
    ){
        return paymentService.createPayment(payment,fieldId, book_hours);
    }
}
