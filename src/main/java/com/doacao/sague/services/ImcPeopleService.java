package com.doacao.sague.services;

import com.doacao.sague.model.dto.ImcByAgeDTO;
import com.doacao.sague.model.dto.query.ImcQueryDTO;
import com.doacao.sague.model.dto.PercetageObeseByGenderDTO;
import com.doacao.sague.model.dto.query.OverweightPeopleByGenderQueryDTO;
import com.doacao.sague.model.mapper.ImcMapper;
import com.doacao.sague.repository.ImcPeopleRepository;
import com.doacao.sague.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImcPeopleService {

    private final ImcMapper imcMapper;

    private final ImcPeopleRepository imcPeopleRepository;

    public List<ImcByAgeDTO> imcAverageAgePeople() {
        List<ImcQueryDTO> imc = imcPeopleRepository.averageAgeImc();

        return imc.stream().map(
                agePerson -> imcMapper.toImcByAgeDTO(agePerson)
        ).collect(Collectors.toList());

    }

    public List<PercetageObeseByGenderDTO> percetageObeseByGender() {
        List<OverweightPeopleByGenderQueryDTO> quantidadePessoasObesasPorGenero = imcPeopleRepository.percentageObeseByGender();

        return quantidadePessoasObesasPorGenero
                .stream()
                .map(data -> PercetageObeseByGenderDTO.builder()
                        .gender(data.getGender())
                        .percentageOverWeight(Utils.calculatePercentage(BigDecimal.valueOf(data.getOverWeight()), BigDecimal.valueOf(data.getTotal()))) // ! Total nunca vai ser 0, ele é um resultado de um count(*) em uma agregação
                        .build()
                ).collect(Collectors.toList());
    }
}
