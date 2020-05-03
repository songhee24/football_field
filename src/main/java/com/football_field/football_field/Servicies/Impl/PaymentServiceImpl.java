package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Company;
import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Repositories.PaymentRepository;
import com.football_field.football_field.Servicies.CompanyService;
import com.football_field.football_field.Servicies.CustomerService;
import com.football_field.football_field.Servicies.PaymentService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CompanyService companyService;

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
    public Payment findPaymentByStatusAndAccountFrom_Id(Status status,Long id) {
        return paymentRepository.findPaymentByStatusAndAccountFrom_Id(status,id);
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setStatus(Status.ACCEPTED);
        Customer customer = customerService.getById(payment.getAccountFrom().getId());
        customer.setBalance(customer.getBalance().subtract(payment.getAmount()));

        Company company = companyService.getById(payment.getAccountTo().getId());
        company.setScore(company.getScore().add(payment.getAmount()));
        payment.setAccountFrom(customer);
        payment.setAccountTo(company);
        return save(payment);
    }

    @Override
    public Payment save(Payment item) {
        return paymentRepository.save(item);
    }

}
