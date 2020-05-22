package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Company;
import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Repositories.PaymentRepository;
import com.football_field.football_field.Servicies.CompanyService;
import com.football_field.football_field.Servicies.UserService;
import com.football_field.football_field.Servicies.FootballFieldService;
import com.football_field.football_field.Servicies.PaymentService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FootballFieldService footballFieldService;

    @Override
    public Payment getById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.get();
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPaymentByStatusAndAccountFrom_Id(Status status,Long customer_id) {
        return paymentRepository.findPaymentByStatusAndAccountFrom_Id(status, customer_id);
    }


    @Override
    public Payment createPayment(Payment payment, Long fieldId, int book_hours) {
        //TODO change login for status
        payment.setStatus(Status.ACCEPTED);
        //find the customer who wants to book
        User customer = userService.getById(payment.getAccountFrom().getId());
        //find the field that i wanna to book
        FootballField footballField = footballFieldService.getById(fieldId);
        //Customer paying
//        customer.setBalance(customer.getBalance().subtract(footballField.getCost().multiply(new BigDecimal(book_hours))));
        //We'he got money
        Company company = companyService.getById(payment.getAccountTo().getId());
        //Changed our wallet(put customer's money)
        company.setScore(company.getScore().add(footballField.getCost().multiply(new BigDecimal(book_hours))));
        //saving
        payment.setAccountFrom(customer);
        payment.setAccountTo(company);
        return save(payment);
    }

    @Override
    public Payment save(Payment item) {
        return paymentRepository.save(item);
    }

}
