package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.FootballPlayground;
import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Repositories.FootballFieldRepository;
import com.football_field.football_field.Servicies.FootballPlaygroundService;
import com.football_field.football_field.Servicies.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballPlaygroundServiceImpl implements FootballPlaygroundService {
    @Autowired
    private FootballFieldRepository footballFieldRepository;

    @Autowired
    private OwnerService ownerService;

    @Override
    public FootballPlayground getById(Long id) {
        Optional<FootballPlayground> footballField = footballFieldRepository.findById(id);
        return footballField.get();
    }

    @Override
    public FootballPlayground create(FootballPlayground footballPlayground) {
        Owner owner = ownerService.getById(footballPlayground.getOwner().getId());
        footballPlayground.setOwner(owner);
        return save(footballPlayground);
    }

    @Override
    public List<FootballPlayground> getAll() {
        return footballFieldRepository.findAll();
    }

    @Override
    public FootballPlayground save(FootballPlayground item) {
        return footballFieldRepository.save(item);
    }
}
