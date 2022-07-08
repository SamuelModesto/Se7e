package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InternshipModality {

    OBG("Obrigatório"),
    NOBG("Não Obrigatório");

    private String description;
}
