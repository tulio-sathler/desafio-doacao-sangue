package com.doacao.sague.controllers;

import com.doacao.sague.model.dto.query.PersonByStateDTO;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;


    @PostMapping("/import-all")
    public ResponseEntity<List<PersonDTO>> importPeople(@RequestBody @Validated List<PersonDTO> people) {
        return new ResponseEntity<>(personService.saveAll(people), HttpStatus.CREATED);
    }

    //TODO adicionar de varias vezes

    @GetMapping("/person-by-state")
    public ResponseEntity<List<PersonByStateDTO>> candidatesByStates () {
        return new ResponseEntity<>(personService.amountPeopleByState(), HttpStatus.OK) ;
    }

}
