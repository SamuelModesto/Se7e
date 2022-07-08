package com.unipampa.sete.entities;

import com.unipampa.sete.enums.Course;
import com.unipampa.sete.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "intern")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    private InternAddress address;

}
