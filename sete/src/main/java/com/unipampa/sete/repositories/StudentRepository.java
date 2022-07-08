package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "delete from student s where s.internship_id  = ?1", nativeQuery = true)
//    void deletePrimaryKeyById(Integer id);
}
