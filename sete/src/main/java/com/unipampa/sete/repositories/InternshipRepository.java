package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Integer> {


    @Query(value = "select name, email, i.*\n" +
            "from tb_user tu\n" +
            "         inner join student s on tu.id = s.user_id\n" +
            "         inner join internship i on i.id = s.internship_id\n" +
            "where tu.email = ?1", nativeQuery = true)
    List<Internship> findAllByUserLogged(String email);
}
