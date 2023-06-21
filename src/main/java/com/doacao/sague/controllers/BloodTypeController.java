package com.doacao.sague.controllers;

import com.doacao.sague.model.dto.BloodTypeDTO;
import com.doacao.sague.services.BloodTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blood-type")
public class BloodTypeController {

    private final BloodTypeService service;

    @GetMapping("/average")
    public ResponseEntity<List<BloodTypeDTO>> averageAgeByBloodType() {
        return new ResponseEntity<>(service.averageAgeByBlood(), HttpStatus.OK);
    }

}
