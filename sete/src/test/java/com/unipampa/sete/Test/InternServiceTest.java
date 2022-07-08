package com.unipampa.sete.Test;


import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.enums.Course;
import com.unipampa.sete.enums.State;
import com.unipampa.sete.repositories.InternRepository;
import com.unipampa.sete.services.InternService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InternServiceTest {

    @Autowired
    private InternService service;

    @Autowired
    private InternRepository repository;

    @Test
    public void deveSalvarInternComSucesso(){
        Intern intern = buildIntern();

        service.saveIntern(intern);

        Assertions.assertThat(repository.findById(intern.getId()).get().equals(intern));
    }


    public Intern buildIntern(){
        Intern intern = new Intern();
        intern.getAddress().setStreet("Rua teste");
        intern.getAddress().setCity("Teste");
        intern.setCourse(Course.ALCC);
        intern.getAddress().setDistrict("Teste");
        intern.setName("Teste");
        intern.setPhoneNumber("Teste");
        intern.getAddress().setState(State.SP);
        intern.getAddress().setZipCode("Teste");


        return intern;
    }



}
