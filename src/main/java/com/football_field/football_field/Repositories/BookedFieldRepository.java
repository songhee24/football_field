package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedFieldRepository extends JpaRepository<BookedField,Long> {
}
