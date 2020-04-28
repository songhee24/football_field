package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Entities.Request;
import com.football_field.football_field.Repositories.RequestRepository;
import com.football_field.football_field.Servicies.CustomerService;
import com.football_field.football_field.Servicies.RequestService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private CustomerService customerService;

    @Override
    public Request getById(Long id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.get();
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request createRequest(Request request,Long id) {
        List<Customer> customers = new ArrayList<>();
//        Customer customerId = request.getCustomers().stream().filter(customer -> customer.getId().equals(id)).findAny().orElse(null);
        Customer customer = customerService.getById(id);
        customers.add(customer);
        request.setStatus(Status.AWAITING);
        request.setCustomers(customers);
        return save(request);
    }

    @Override
    public Request save(Request item) {
        return requestRepository.save(item);
    }
}
