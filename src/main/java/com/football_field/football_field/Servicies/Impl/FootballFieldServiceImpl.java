package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Repositories.FootballFieldRepository;
import com.football_field.football_field.Servicies.FootballFieldService;
import com.football_field.football_field.Servicies.OwnerService;
import com.football_field.football_field.side_models.FootballFieldNoOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FootballFieldServiceImpl implements FootballFieldService {
    @Autowired
    private FootballFieldRepository footballFieldRepository;

    @Autowired
    private OwnerService ownerService;

    @Override
    public FootballField getById(Long id) {
        Optional<FootballField> footballField = footballFieldRepository.findById(id);
        return footballField.get();
    }

    @Override
    public FootballField create(FootballField footballField) {
        Owner owner = ownerService.getById(footballField.getOwner().getId());
        footballField.setOwner(owner);
        return save(footballField);
    }

    @Override
    public List<FootballFieldNoOwner> getAllWithoutOwner() {
        List<FootballField> all = getAll();
        List<FootballFieldNoOwner> newList = new ArrayList<>();
        for (FootballField field :
                all) {
            newList.add(
                    FootballFieldNoOwner.builder()
                            .address(field.getAddress())
                            .cost(field.getCost())
                            .id(field.getId())
                            .build()
            );
        }
        return newList;
    }

    @Override
    public List<FootballField> getAll() {
        return footballFieldRepository.findAll();
    }

    @Override
    public FootballField save(FootballField item) {
        return footballFieldRepository.save(item);
    }
}
