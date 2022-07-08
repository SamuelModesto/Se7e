package com.unipampa.sete.dto;

import com.unipampa.sete.entities.Company;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.RegisteredCompany;
import com.unipampa.sete.entities.Intern;
import com.unipampa.sete.enums.InternshipModality;
import com.unipampa.sete.enums.InternshipType;
import com.unipampa.sete.enums.StatusInternship;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@NoArgsConstructor
@Getter
@Setter
public class InternshipDTO {

    private int id;
    private Intern intern;
    private Company company;
    private String nameTeacher;
    private InternshipType type;
    private InternshipModality modality;
    private boolean paid;
    private Double valuePaid;
    private Calendar startValidity;
    private Calendar endValidity;
    private int dailyWorkload;
    private int weeklyWorkload;
    private Calendar journeyStartTime;
    private int interval;
    private String activitiesPlan;
    private StatusInternship statusInternship;
//    private String emailLogged;


    public InternshipDTO(Internship internship){
        if(internship.getUnregisteredCompany() != null){
            company = internship.getUnregisteredCompany();
        } else if(internship.getRegisteredCompanyRegistered() != null){
            company = internship.getRegisteredCompanyRegistered();
        }
        intern = internship.getIntern();
    }


}
