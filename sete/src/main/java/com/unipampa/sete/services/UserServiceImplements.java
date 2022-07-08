package com.unipampa.sete.services;

import com.unipampa.sete.entities.*;
import com.unipampa.sete.exception.AutenticationException;
import com.unipampa.sete.interfaces.UserService;
import com.unipampa.sete.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public int authenticate(String email, String password) {
        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty() || !user.get().getEmail().equalsIgnoreCase(email)) {
            throw new AutenticationException("Usuário não encontrado para o email informado.");
        }
        if (!user.get().getPassword().equals(password)) {
            throw new AutenticationException("Senha inválida");
        }
        if (user.get().getPassword().equals(password) && user.get().getEmail().equalsIgnoreCase(email)) {
            System.out.println("Usuário autenticado!");
        }
        return user.get().getPermissionType().getUserType();
    }

    public Optional<User> captureUserLogged(String email) {
        return repository.findByEmail(email);

    }
    public Optional<User> findById(int id){
        return repository.findById(id);
    }
}


