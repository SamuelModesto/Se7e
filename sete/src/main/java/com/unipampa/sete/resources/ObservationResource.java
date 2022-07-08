package com.unipampa.sete.resources;


import com.unipampa.sete.dto.ObservationDTO;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.Observation;
import com.unipampa.sete.entities.User;
import com.unipampa.sete.enums.PermissionEnum;
import com.unipampa.sete.exception.BusinessRuleException;
import com.unipampa.sete.interfaces.UserService;
import com.unipampa.sete.repositories.ObservationRepository;
import com.unipampa.sete.services.InternshipService;
import com.unipampa.sete.services.ObservationService;
import com.unipampa.sete.services.UserServiceImplements;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/observation")
@CrossOrigin (origins = "*")
public class ObservationResource {

    @Autowired
    private ObservationService service;

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private ObservationRepository repository;

    @Autowired
    private UserServiceImplements userService;

    @PostMapping("/save")
    public ResponseEntity saveObservation(@RequestBody ObservationDTO dto) {
        Observation observation = new Observation();
        Optional<Internship> internship = internshipService.findInternshipById(dto.getIdInternship());
        Optional<User> user = userService.findById(dto.getIdUser());
        try {
            if (user.get().getPermissionType().equals(PermissionEnum.TEACHER) || user.get().getPermissionType().equals(PermissionEnum.INTERFACE)) {

                observation.setObservation(dto.getObservation());
                observation.setInternship(internship.get());
                observation.setUser(user.get());
                service.saveObservation(observation);

            }
            return new ResponseEntity(observation, HttpStatus.OK);
        } catch (BusinessRuleException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/getAllObservations/{id}")
    public ResponseEntity<List<String>> getObservationsByInternshipId(@PathVariable("id")Integer id){

        List<String> observations = repository.findObservationsByInternshipId(id);

        return new ResponseEntity(observations, HttpStatus.OK);
    }

}
