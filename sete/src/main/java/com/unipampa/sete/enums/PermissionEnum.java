package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
public enum PermissionEnum {

    ADM(1, "Administrador Prograd"),
    STUDENT(2,"Aluno"),
    TEACHER(3,"Orientador"),
    INTERFACE(4,"Interface de estagio"),
    COORD(5,"Coordenador de curso");

    private final int userType;
    private final String description;
}
