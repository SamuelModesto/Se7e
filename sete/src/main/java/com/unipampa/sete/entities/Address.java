package com.unipampa.sete.entities;

import com.unipampa.sete.enums.State;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@MappedSuperclass
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String street;

    @Column
    private String district;

    @Column
    private String zipCode;

    @Column
    private String city;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;
}
