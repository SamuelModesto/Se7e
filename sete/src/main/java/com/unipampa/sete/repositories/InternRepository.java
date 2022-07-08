package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Integer> {

//    Optional<Student> findByEmail(String email);
}
