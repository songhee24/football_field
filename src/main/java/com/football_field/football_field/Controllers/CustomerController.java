package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Servicies.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @CrossOrigin
    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
