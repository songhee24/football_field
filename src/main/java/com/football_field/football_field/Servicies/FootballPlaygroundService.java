package com.football_field.football_field.Servicies;


import com.football_field.football_field.Entities.FootballPlayground;

public interface FootballPlaygroundService extends BaseService<FootballPlayground> {
    FootballPlayground create(FootballPlayground footballPlayground);
}
