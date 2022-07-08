package com.unipampa.sete.services;

import com.unipampa.sete.dto.CompanyDTO;
import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.RegisteredCompany;
import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.UnregisteredCompany;
import com.unipampa.sete.repositories.CompanyRepository;
import com.unipampa.sete.repositories.UnregisteredCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private UnregisteredCompanyRepository unregisteredCompanyRepository;

    @Autowired
    private InternshipService internshipService;


    public void saveCompany(RegisteredCompany registeredCompany){
        repository.save(registeredCompany);
    }

    public Optional<RegisteredCompany> findCompanyById(Integer id){
       return  repository.findById(id);
    }

    public Optional<UnregisteredCompany> findUnregisteredCompany(Integer id){
        return unregisteredCompanyRepository.findById(id);
    }

    public List<RegisteredCompany> findAllCompanies(){
        return repository.findAll();
    }

    public void saveUnregisteredCompany(UnregisteredCompany unregisteredCompany){
        unregisteredCompanyRepository.save(unregisteredCompany);
    }

    public RegisteredCompany buildCompanyRegistered(CompanyDTO dto){
        RegisteredCompany registeredCompany = new RegisteredCompany();
        registeredCompany.setAddress(dto.getAddress());
        registeredCompany.setName(dto.getName());
        registeredCompany.setPhoneNumber(dto.getPhoneNumber());
        registeredCompany.setNameLegalRepresentative(dto.getNameLegalRepresentative());
        registeredCompany.setOfficeLegalRepresentative(dto.getOfficeLegalRepresentative());
        registeredCompany.setNameSupervisor(dto.getNameSupervisor());
        registeredCompany.setOfficeSupervisor(dto.getOfficeSupervisor());
        registeredCompany.setStatusCompany(dto.getStatusCompany());

        return registeredCompany;
    }

    public UnregisteredCompany buildCompanyUnregistered(InternshipDTO dto) {
        UnregisteredCompany company = new UnregisteredCompany();
        company.setName(dto.getCompany().getName());
        company.setAddress(dto.getCompany().getAddress());
        company.setPhoneNumber(dto.getCompany().getPhoneNumber());
        company.setNameLegalRepresentative(dto.getCompany().getNameLegalRepresentative());
        company.setOfficeLegalRepresentative(dto.getCompany().getOfficeLegalRepresentative());
        company.setNameSupervisor(dto.getCompany().getNameSupervisor());
        company.setOfficeSupervisor(dto.getCompany().getOfficeSupervisor());
        return company;
    }

    public Internship checkCompanyRegistration(Optional<RegisteredCompany> company, InternshipDTO dto,
                                               Intern intern) {
        Internship internship;
        if (company.isEmpty()) {
            UnregisteredCompany unregisteredCompany = buildCompanyUnregistered(dto);
            saveUnregisteredCompany(unregisteredCompany);
            internship = internshipService.buildInternship(dto, intern, null, unregisteredCompany);
        } else {
            internship = internshipService.buildInternship(dto, intern, company.get(), null);
        }
        return internship;
    }

    public void updateCompany(RegisteredCompany registeredCompany){
        repository.save(registeredCompany);
    }

}
