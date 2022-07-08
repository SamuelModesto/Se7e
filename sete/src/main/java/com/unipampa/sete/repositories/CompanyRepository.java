package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.RegisteredCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<RegisteredCompany, Integer> {
}
