package com.unipampa.sete.dto;

import com.unipampa.sete.entities.Address;
import com.unipampa.sete.entities.CompanyAddress;
import com.unipampa.sete.enums.State;
import com.unipampa.sete.enums.StatusCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO{

    private String name;
    private CompanyAddress address;
    private String phoneNumber;
    private String nameLegalRepresentative;
    private String officeLegalRepresentative;
    private String nameSupervisor;
    private String officeSupervisor;

    private StatusCompany statusCompany;

}

