package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Repositories.OwnerRepository;
import com.football_field.football_field.Servicies.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner getById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.get();
    }

    @Override
    public Owner create(Owner owner, Long requestId) {
        return null;
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner save(Owner item) {
        return ownerRepository.save(item);
    }
}
