package com.unipampa.sete.repositories;

import com.unipampa.sete.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

        Optional<User> findByEmail(String email);
}
