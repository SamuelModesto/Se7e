package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AliasFor;
@Getter
@AllArgsConstructor
public enum InternshipType {

    P("Presencial"),
    R("Remoto");

    private String description;
}
