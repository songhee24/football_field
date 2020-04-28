package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Entities.Request;
import com.football_field.football_field.Repositories.OwnerRepository;
import com.football_field.football_field.Servicies.OwnerService;
import com.football_field.football_field.Servicies.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private RequestService requestService;

    @Override
    public Owner getById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.get();
    }

    @Override
    public Owner create(Owner owner, Long requestId) {
        List<Request> requests = new ArrayList<>();
        Request request = requestService.getById(requestId);
        requests.add(request);
        owner.setRequest(requests);
        return save(owner);
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
