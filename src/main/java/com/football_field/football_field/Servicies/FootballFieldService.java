package com.football_field.football_field.Servicies;


import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.side_models.FootballFieldNoOwner;

import java.util.List;

public interface FootballFieldService extends BaseService<FootballField> {
    FootballField create(FootballField footballField);

    List<FootballFieldNoOwner> getAllWithoutOwner();

    List<FootballField> getAllByOwner_Id(Long id);
}
