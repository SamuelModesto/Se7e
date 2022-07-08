package com.unipampa.sete.Test;


import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.Observation;
import com.unipampa.sete.entities.User;
import com.unipampa.sete.repositories.ObservationRepository;
import com.unipampa.sete.services.InternshipService;
import com.unipampa.sete.services.ObservationService;
import com.unipampa.sete.services.UserServiceImplements;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ObservationServiceTest {

    @Autowired
    private ObservationService service;

    @Autowired
    private ObservationRepository repository;

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private UserServiceImplements userService;

    @Test
    public void deveSalvarObservaçãoComSucesso(){

        Observation observation = buildObservation();

        service.saveObservation(observation);

        Assertions.assertThat(service.findObservationById(observation.getId()).equals(observation));


    }
    public Observation buildObservation(){
        Observation observation = new Observation();
        Optional<Internship> internship = internshipService.findInternshipById(17);
        Optional<User> user= userService.captureUserLogged("teste@gmail.com");
        observation.setInternship(internship.get());
        observation.setUser(user.get());
        observation.setObservation("Teste");
        return observation;
    }



}
