package com.football_field.football_field.Servicies;


import com.football_field.football_field.Entities.FootballField;

public interface FootballFieldService extends BaseService<FootballField> {
    FootballField create(FootballField footballField);
}
