package com.doacao.sague.controllers;

import com.doacao.sague.model.dto.ImcByAgeDTO;
import com.doacao.sague.model.dto.PercetageObeseByGenderDTO;
import com.doacao.sague.services.ImcPeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/imc")
public class ImcPeopleController {

    private final ImcPeopleService service;

    @GetMapping
    public ResponseEntity<List<ImcByAgeDTO>> averageAgeImcPeople() {
        return new ResponseEntity<>(service.imcAverageAgePeople(), HttpStatus.OK);
    }

    @GetMapping("/weight-by-gender")
    public ResponseEntity<List<PercetageObeseByGenderDTO>> weightByGender() {
        return new ResponseEntity<>(service.percetageObeseByGender(), HttpStatus.OK);
    }

}
