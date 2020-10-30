package br.com.statemachineindividuo.controller;

import br.com.statemachineindividuo.model.Individual;
import br.com.statemachineindividuo.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndividualController {

    @Autowired
    private IndividualRepository repository;

    @PostMapping("/individual")
    public ResponseEntity<Individual> save(@RequestBody Individual individual) {
        try {
            Individual save = repository
                    .save(individual);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
