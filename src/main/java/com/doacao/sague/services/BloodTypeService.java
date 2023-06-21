package com.doacao.sague.services;

import com.doacao.sague.model.dto.BloodTypeDTO;
import com.doacao.sague.model.mapper.BloodTypeMapper;
import com.doacao.sague.repository.BloodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodTypeService {

    private final BloodTypeMapper mapper;

    private final BloodTypeRepository repository;

    public List<BloodTypeDTO> averageAgeByBlood() {
        return repository.averageAgeByBlood()
                .stream()
                .map((e) -> mapper.toBloodTypeDTO(e)
        ).collect(Collectors.toList());
    }
}
