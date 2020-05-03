package com.football_field.football_field.Repositories;

import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.side_models.FootballFieldNoOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FootballFieldRepository extends JpaRepository<FootballField,Long> {
    @Query(value = "select ff.id, ff.address, ff.cost from m_football_fields ff", nativeQuery = true)
    List<FootballFieldNoOwner> getAllWithoutOwner();
//    List< list = em.createQuery("SELECT p.field1, p.field2 FROM Entity p").getResultList();

}
