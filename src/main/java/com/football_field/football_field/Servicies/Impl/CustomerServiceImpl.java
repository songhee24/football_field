package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Repositories.CustomerRepository;
import com.football_field.football_field.Servicies.CustomerService;
import com.football_field.football_field.Servicies.FootballFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        Optional<Customer> customer= customerRepository.findById(id);
        return customer.get();
    }

    @Override
    public List<Customer> findAllById(Long id) {
        return customerRepository.findAllById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer save(Customer item) {
        return customerRepository.save(item);
    }
}
