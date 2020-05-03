package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Statuses.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Payment findPaymentByStatusAndAccountFrom_Id(Status status, Long id);

}
