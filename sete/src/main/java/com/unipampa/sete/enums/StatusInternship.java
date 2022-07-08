package com.unipampa.sete.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusInternship {

    APROVADO(1, "Aprovação da solicitação do estágio"),
    MUDANCA(2, "Solicitação de mudança"),
    ANALISE(3, "Analise da solicitação do estágio");

    private final int userType;
    private final String description;
}
