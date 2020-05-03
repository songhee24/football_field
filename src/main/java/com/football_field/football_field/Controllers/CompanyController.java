package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Company;
import com.football_field.football_field.Servicies.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company save(@RequestBody Company company){
        return companyService.save(company);
    }
}
