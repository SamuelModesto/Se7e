package com.unipampa.sete.dto;
import com.unipampa.sete.enums.PermissionEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String password;

}

