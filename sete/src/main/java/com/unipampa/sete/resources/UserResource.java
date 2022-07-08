package com.unipampa.sete.resources;

import com.unipampa.sete.dto.UserDTO;
import com.unipampa.sete.entities.User;
import com.unipampa.sete.exception.AutenticationException;
import com.unipampa.sete.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping(value = "/authenticate")
    public ResponseEntity authenticate(@RequestBody UserDTO dto){
        try{
            service.authenticate(dto.getEmail(), dto.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (AutenticationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
