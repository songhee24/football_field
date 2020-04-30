package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.FootballField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballFieldRepository extends JpaRepository<FootballField,Long> {
}
