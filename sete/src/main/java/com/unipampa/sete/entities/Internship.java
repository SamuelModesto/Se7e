package com.unipampa.sete.entities;

import com.unipampa.sete.enums.InternshipModality;
import com.unipampa.sete.enums.InternshipType;
import com.unipampa.sete.enums.StatusInternship;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "internship")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Intern intern;

    @OneToOne
    private RegisteredCompany registeredCompanyRegistered;

    @OneToOne
    private UnregisteredCompany unregisteredCompany;

    @Column
    private String nameTeacher;

    @Enumerated(EnumType.STRING)
    private InternshipType type;

    @Enumerated(EnumType.STRING)
    private InternshipModality modality;

    @Column
    private boolean paid;

    @Column
    private Double valuePaid;

    @Column
    private Calendar startValidity;

    @Column
    private Calendar endValidity;

    @Column
    private int dailyWorkload;

    @Column
    private int weeklyWorkload;

    @Column
    private Calendar journeyStartTime;

    @Column
    private int interval;

    @Column
    private String activitiesPlan;

    @Column
    @Enumerated(value = EnumType.STRING)
    private StatusInternship statusInternship;

}
