package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Course {

    ALCC("Alegrete - Ciência da computação"),
    ALEA("Alegrete - Engenharia Agrícola"),
    ALEC("Alegrete - Engenharia Civil"),
    ALES("Alegrete - Engenharia de Software"),
    ALET("Alegrete - Engenharia de Telecomunicações"),
    ALEE("Alegrete - Engenharia Elétrica"),
    ALEM("Alegrete - Engenharia Mecânica");

    private final String description;
}
