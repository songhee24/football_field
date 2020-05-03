package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Repositories.BookedFieldRepository;
import com.football_field.football_field.Repositories.CustomerRepository;
import com.football_field.football_field.Servicies.BookedFieldService;
import com.football_field.football_field.Servicies.CustomerService;
import com.football_field.football_field.Servicies.FootballFieldService;
import com.football_field.football_field.Servicies.PaymentService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookedFieldServiceImpl implements BookedFieldService {
    @Autowired
    private BookedFieldRepository bookedFieldRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FootballFieldService footballFieldService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public BookedField getById(Long id) {
        Optional<BookedField> booking = bookedFieldRepository.findById(id);
        return booking.get();
    }

    @Override
    public List<BookedField> getAll() {
        return bookedFieldRepository.findAll();
    }

    @Override
    public BookedField createBooking(BookedField bookedField, Status status,Long id) {
        Payment payment = paymentService.findPaymentByStatusAndAccountFrom_Id(status, id);
        if (payment.getStatus() == Status.ACCEPTED){
            Customer customer = customerService.getById(payment.getAccountFrom().getId());
            FootballField field = footballFieldService.getById(bookedField.getFootballField().getId());
            bookedField.setCustomer(customer);
            bookedField.setFootballField(field);
            return save(bookedField);
        }
        else return null;
    }

    @Override
    public BookedField save(BookedField item) {
        return bookedFieldRepository.save(item);
    }
}
