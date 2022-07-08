package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.UnregisteredCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnregisteredCompanyRepository extends JpaRepository<UnregisteredCompany, Integer> {
}
