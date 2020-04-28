package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer> {
    Customer createCustomer(Customer customer);

    List<Customer> findAllById(Long id);

}
