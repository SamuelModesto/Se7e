package com.unipampa.sete.services;

import com.unipampa.sete.entities.Observation;
import com.unipampa.sete.repositories.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservationService  {

    @Autowired
    private ObservationRepository repository;

    public void saveObservation(Observation observation){
        repository.save(observation);
    }
    public Optional<Observation> findObservationById(Integer id){
        return repository.findById(id);

    }


}
