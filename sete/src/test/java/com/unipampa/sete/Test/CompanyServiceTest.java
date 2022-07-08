package com.unipampa.sete.Test;

import com.unipampa.sete.entities.Company;
import com.unipampa.sete.entities.UnregisteredCompany;
import com.unipampa.sete.enums.State;
import com.unipampa.sete.enums.StatusCompany;
import com.unipampa.sete.repositories.UnregisteredCompanyRepository;
import com.unipampa.sete.services.CompanyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private CompanyService service;

    @Autowired
    private UnregisteredCompanyRepository repository;


//    @Test
//    public void deveSalvarCompanyComSucesso(){
//         company = buildCompany();
//
//        service.saveCompany(company);
//
//        Assertions.assertThat(service.findCompanyById(company.getId()).get().equals(company));
//    }
    @Test
    public void deveSalvarUnregisteredCompanyComSucesso(){
        UnregisteredCompany unregisteredCompany = buildUnregisteredCompany();

        service.saveUnregisteredCompany(unregisteredCompany);

        Assertions.assertThat(repository.findById(unregisteredCompany.getId()).equals(unregisteredCompany));

    }

//    @Test
//    public void devePegarUmaCompanyPeloIdComSucesso(){
//        Optional<Company> company = service.findCompanyById(2);
//
//        Assertions.assertThat(company.get().getId()).isEqualTo(2);
//        Assertions.assertThat(company.get().getAddress().getStreet()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getAddress().getCity()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getStatusCompany()).isEqualTo(StatusCompany.ATIVO);
//        Assertions.assertThat(company.get().getName()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getAddress().getDistrict()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getAddress().getState()).isEqualTo(State.SP);
//        Assertions.assertThat(company.get().getNameLegalRepresentative()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getNameSupervisor()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getAddress().getZipCode()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getPhoneNumber()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getOfficeSupervisor()).isEqualTo("Teste");
//        Assertions.assertThat(company.get().getOfficeLegalRepresentative()).isEqualTo("Teste");
//
//    }

//    @Test
//    public void deveRetornarUmaListaNãoVaziaDeCompany(){
//         List<Company> companies = service.findAllCompanies();
//
//         Assertions.assertThat(companies).isNotNull();
//    }
    public UnregisteredCompany buildUnregisteredCompany(){
        UnregisteredCompany unregisteredCompany = new UnregisteredCompany();
        unregisteredCompany.getAddress().setState(State.SC);
        unregisteredCompany.getAddress().setDistrict("Teste");
        unregisteredCompany.getAddress().setCity("Teste");
        unregisteredCompany.setName("Teste");
        unregisteredCompany.getAddress().setStreet("Teste");
        unregisteredCompany.getAddress().setZipCode("Teste");
        unregisteredCompany.setPhoneNumber("Teste");
        unregisteredCompany.setNameLegalRepresentative("Teste");
        unregisteredCompany.setNameSupervisor("Teste");
        unregisteredCompany.setOfficeLegalRepresentative("Teste");
        unregisteredCompany.setOfficeSupervisor("Teste");
        return unregisteredCompany;
    }

//    public Company buildCompany(){
//        Company company = new Company();
//        company.getAddress().setCity("Teste");
//        company.getAddress().setDistrict("Teste");
//        company.setName("Teste");
//        company.getAddress().setZipCode("Teste");
//        company.setStatusCompany(StatusCompany.ATIVO);
//        company.getAddress().setState(State.SP);
//        company.getAddress().setStreet("Teste");
//        company.setNameLegalRepresentative("Teste");
//        company.setNameSupervisor("Teste");
//        company.setOfficeSupervisor("Teste");
//        company.setPhoneNumber("Teste");
//        company.setOfficeLegalRepresentative("Teste");
//        return company;
//    }
}
