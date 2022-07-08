package com.unipampa.sete.Test;

import com.unipampa.sete.entities.User;
import com.unipampa.sete.enums.PermissionEnum;
import com.unipampa.sete.repositories.UserRepository;
import com.unipampa.sete.services.UserServiceImplements;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImplements service;

    @Autowired
    private UserRepository repository;

    @Test
    public void devePegarUmUsuarioLogadoPeloEmailComSucesso(){
        Optional<User> user =service.captureUserLogged("teste@gmail.com");

        Assertions.assertThat(user.get().getEmail().equals("teste@gmail.com"));
        Assertions.assertThat(user.get().getPassword().equals("1345"));
        Assertions.assertThat(user.get().getName().equals("Denner"));
        Assertions.assertThat(user.get().getPermissionType().equals(PermissionEnum.INTERFACE));
        Assertions.assertThat(user.get().getId()).isEqualTo(5);
    }
    @Test
    public void devePegarUmUsuarioPeloIdComSucesso(){
        Optional<User> user =service.findById(5);

        Assertions.assertThat(user.get().getEmail().equals("teste@gmail.com"));
        Assertions.assertThat(user.get().getPassword().equals("1345"));
        Assertions.assertThat(user.get().getName().equals("Denner"));
        Assertions.assertThat(user.get().getPermissionType().equals(PermissionEnum.INTERFACE));
        Assertions.assertThat(user.get().getId()).isEqualTo(5);
    }
}
