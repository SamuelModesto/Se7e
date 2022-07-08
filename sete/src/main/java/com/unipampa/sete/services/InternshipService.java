package com.unipampa.sete.services;

import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.RegisteredCompany;
import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.UnregisteredCompany;
import com.unipampa.sete.enums.StatusInternship;
import com.unipampa.sete.repositories.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository repository;

    public void saveInternship(Internship internship) {
        internship.setStatusInternship(StatusInternship.ANALISE);
        repository.save(internship);
    }

    public Optional<Internship> findInternshipById(Integer id){
        return repository.findById(id);
    }

    public Internship updateInternship(Internship internship){
        return repository.save(internship);
    }

    public List<InternshipDTO> findAll(String email){
        List<Internship> result = repository.findAll();
        return result.stream().map(e -> new InternshipDTO(e)).collect(Collectors.toList());
    }

    public void deleteInternshipById(Integer id){
        repository.deleteById(id);
    }

    public Internship buildInternship(InternshipDTO dto, Intern intern, RegisteredCompany registeredCompanyRegistered,
                                      UnregisteredCompany unregisteredCompany) {
        Internship internship = new Internship();
        internship.setIntern(intern);
        internship.setRegisteredCompanyRegistered(registeredCompanyRegistered);
        internship.setUnregisteredCompany(unregisteredCompany);
        internship.setNameTeacher(dto.getNameTeacher());
        internship.setType(dto.getType());
        internship.setModality(dto.getModality());
        internship.setPaid(dto.isPaid());
        internship.setValuePaid(dto.getValuePaid());
        internship.setStartValidity(dto.getStartValidity());
        internship.setEndValidity(dto.getEndValidity());
        internship.setDailyWorkload(dto.getDailyWorkload());
        internship.setWeeklyWorkload(dto.getWeeklyWorkload());
        internship.setJourneyStartTime(dto.getJourneyStartTime());
        internship.setInterval(dto.getInterval());
        internship.setActivitiesPlan(dto.getActivitiesPlan());
        return internship;
    }

}
