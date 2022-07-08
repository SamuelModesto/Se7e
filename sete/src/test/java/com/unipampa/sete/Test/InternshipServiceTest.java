package com.unipampa.sete.Test;

import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.Company;
import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.enums.InternshipModality;
import com.unipampa.sete.enums.InternshipType;
import com.unipampa.sete.enums.StatusInternship;
import com.unipampa.sete.services.InternshipService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class InternshipServiceTest {

    @Autowired
    private InternshipService service;



    @Test
    public void deveCadastrarUmInternshipComSucesso(){
        Internship internship = buildInternship();

        service.saveInternship(internship);

        Assertions.assertThat(service.findInternshipById(internship.getId()).get().equals(internship));


    }
//    @Test
//    public void deveCadastrarUmInternshipComFalha(){
//        Internship internship = buildInternship();
//        internship.setId(13);
//        service.saveInternship(internship);
//
//        Assertions.assertThat(internship.getNameTeacher()).isEqualTo("Teste");
//        Assertions.assertThat(internship.getType()).isEqualTo(InternshipType.P);
//        Assertions.assertThat(internship.getModality()).isEqualTo(InternshipModality.OBG);
//        Assertions.assertThat(internship.getValuePaid()).isEqualTo(300.00);
//        Assertions.assertThat(internship.getDailyWorkload()).isEqualTo(6);
//        Assertions.assertThat(internship.getWeeklyWorkload()).isEqualTo(5);
//        Assertions.assertThat(internship.getInterval()).isEqualTo(3);
//        Assertions.assertThat(internship.getActivitiesPlan()).isEqualTo("teste");
//        Assertions.assertThat(internship.getStatusInternship()).isNotEqualTo(StatusInternship.MUDANCA);
//
//    }

    @Test
    public void deveProcurarUmInternshipPeloIdComSucesso(){

        Optional<Internship> internship1 = service.findInternshipById(13);

        Assertions.assertThat(internship1.get().getNameTeacher()).isEqualTo("Teste");
        Assertions.assertThat(internship1.get().getType()).isEqualTo(InternshipType.P);
        Assertions.assertThat(internship1.get().getModality()).isEqualTo(InternshipModality.OBG);
        Assertions.assertThat(internship1.get().getValuePaid()).isEqualTo(300.00);
        Assertions.assertThat(internship1.get().getDailyWorkload()).isEqualTo(6);
        Assertions.assertThat(internship1.get().getWeeklyWorkload()).isEqualTo(5);
        Assertions.assertThat(internship1.get().getInterval()).isEqualTo(3);
        Assertions.assertThat(internship1.get().getActivitiesPlan()).isEqualTo("teste");
        Assertions.assertThat(internship1.get().getStatusInternship()).isEqualTo(StatusInternship.ANALISE);
    }
//    @Test
//    public void deveProcurarUmInternshipPeloIdComFalha(){
//
//        Optional<Internship> internship1 = service.findInternshipById(6);
//
//        Assertions.assertThat(internship1.get().getNameTeacher()).isEqualTo("Teste");
//        Assertions.assertThat(internship1.get().getType()).isEqualTo(InternshipType.P);
//        Assertions.assertThat(internship1.get().getModality()).isEqualTo(InternshipModality.OBG);
//        Assertions.assertThat(internship1.get().getValuePaid()).isEqualTo(300.00);
//        Assertions.assertThat(internship1.get().getDailyWorkload()).isEqualTo(6);
//        Assertions.assertThat(internship1.get().getWeeklyWorkload()).isEqualTo(5);
//        Assertions.assertThat(internship1.get().getInterval()).isEqualTo(3);
//        Assertions.assertThat(internship1.get().getActivitiesPlan()).isEqualTo("teste");
//        Assertions.assertThat(internship1.get().getStatusInternship()).isEqualTo(StatusInternship.MUDANCA);
//    }
    @Test
    public void deveAlterarUmInternshipComSucesso(){
        Internship internship = buildInternship();
        Intern intern = buildIntern();
        Company company = buildCompany();
        internship.setId(14);
        internship.setIntern(intern);
//        internship.setCompanyRegistered(company);
        internship.setStatusInternship(StatusInternship.APROVADO);


        Internship internship1 = service.updateInternship(internship);


        Assertions.assertThat(service.findInternshipById(internship1.getId()).equals(internship.getId()));

    }

    @Test
    public void deveRetornarTodosInternshipComSucesso(){

        List<InternshipDTO> internship1 = service.findAll("tadeu@gmail.com");

        Assertions.assertThat(internship1).isNotNull();
    }
    @Test
    public void deveExcluirUmInternshipComSucesso(){
        Internship internship = buildInternship();

         service.saveInternship(internship);


        service.deleteInternshipById(internship.getId());

        Assertions.assertThat(service.findInternshipById(internship.getId()).equals(null));
    }


    public Internship buildInternship(){
        Internship internship = new Internship();
        internship.setNameTeacher("Teste");
        internship.setType(InternshipType.P);
        internship.setModality(InternshipModality.OBG);
        internship.setPaid(true);
        internship.setValuePaid(300.00);
        internship.setDailyWorkload(6);
        internship.setWeeklyWorkload(5);
        internship.setInterval(3);
        internship.setActivitiesPlan("teste");
        return internship;
    }
    public Intern buildIntern(){
        Intern intern = new Intern();
        intern.setId(6);
        return intern;
    }
    public Company buildCompany(){
        Company company = new Company();
        company.setId(1);
        return company;
    }


}
