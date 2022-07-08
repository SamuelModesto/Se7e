package com.unipampa.sete.entities;

import com.unipampa.sete.enums.State;
import com.unipampa.sete.enums.StatusCompany;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Company {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private CompanyAddress address;

    @Column
    private String phoneNumber;

    @Column
    private String nameLegalRepresentative;

    @Column
    private String officeLegalRepresentative;

    @Column
    private String nameSupervisor;

    @Column
    private String officeSupervisor;

    @Enumerated(EnumType.ORDINAL)
    private StatusCompany statusCompany;

}
