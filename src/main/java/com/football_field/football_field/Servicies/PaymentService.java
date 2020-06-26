package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Statuses.Status;

public interface PaymentService extends  BaseService<Payment>{
    Payment createPayment(Payment payment, Long field_id, int book_hours);

    Payment findPaymentByStatusAndAccountFrom_Id(Status status, Long customer_id);

}
