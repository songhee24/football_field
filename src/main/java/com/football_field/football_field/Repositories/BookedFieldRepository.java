package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.BookedField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedFieldRepository extends JpaRepository<BookedField,Long> {

    List<BookedField> getAllByFootballField_Id(Long id);
}
