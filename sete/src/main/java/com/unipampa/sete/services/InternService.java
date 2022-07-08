package com.unipampa.sete.services;

import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.repositories.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    @Autowired
    private InternRepository repository;

    public void saveIntern(Intern intern) {
        repository.save(intern);
    }

    public Intern buildIntern(InternshipDTO dto) {
        Intern intern = new Intern();
        intern.setCourse(dto.getIntern().getCourse());
        intern.setName(dto.getIntern().getName());
        intern.setAddress(dto.getIntern().getAddress());
        intern.setPhoneNumber(dto.getIntern().getPhoneNumber());
        return intern;
    }

}
