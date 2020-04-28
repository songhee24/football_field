package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Booking;
import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Repositories.BookingRepository;
import com.football_field.football_field.Repositories.CustomerRepository;
import com.football_field.football_field.Servicies.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Booking getById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.get();
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking save(Booking item) {
        return bookingRepository.save(item);
    }
}
