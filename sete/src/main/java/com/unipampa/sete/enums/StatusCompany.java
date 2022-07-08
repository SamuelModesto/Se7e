package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCompany {

    INATIVO("Empresa inativa no cadastro"),
    ATIVO("Empresa ativa no cadastro");

    private final String description;
}
