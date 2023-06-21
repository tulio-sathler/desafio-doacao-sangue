package com.doacao.sague.controllers;

import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.dto.query.PersonByStateDTO;
import com.doacao.sague.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @RequestMapping(value = "/import-all", method = RequestMethod.POST)
    public ResponseEntity<List<PersonDTO>> importPeople(@RequestBody @Validated List<PersonDTO> people) {
        return new ResponseEntity<>(personService.saveAll(people), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/person-by-state", method = RequestMethod.GET)
    public ResponseEntity<List<PersonByStateDTO>> candidatesByStates () {
        return new ResponseEntity<>(personService.amountPeopleByState(), HttpStatus.OK) ;
    }

}
