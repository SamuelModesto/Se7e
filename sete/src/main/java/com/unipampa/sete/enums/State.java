package com.unipampa.sete.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {

    SP("Sao Paulo"),
    SC("Santa Catarina");


    private final String description;
}
