package com.doacao.sague.controllers;

import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping("/import-all")
    public ResponseEntity<List<PersonDTO>> importPeople(@RequestBody List<PersonDTO> people) {
        return new ResponseEntity<>(personService.saveAll(people), HttpStatus.CREATED);
    }


}
