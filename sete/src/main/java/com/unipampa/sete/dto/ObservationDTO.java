package com.unipampa.sete.dto;

import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ObservationDTO {
    private int id;
    private String observation;
    private int idInternship;
    private int idUser;
}
