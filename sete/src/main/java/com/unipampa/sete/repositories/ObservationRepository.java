package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer> {

    @Query(value = "select observation \n" +
            "from observation tu\n" +
            "inner join internship i on i.id = tu.internship_id\n" +
            "where tu.internship_id = ?1\n", nativeQuery = true)
    List<String> findObservationsByInternshipId(Integer id);


}
