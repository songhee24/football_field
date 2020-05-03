package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Company;
import com.football_field.football_field.Repositories.CompanyRepository;
import com.football_field.football_field.Servicies.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company getById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.get();
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(Company item) {
        return companyRepository.save(item);
    }
}
