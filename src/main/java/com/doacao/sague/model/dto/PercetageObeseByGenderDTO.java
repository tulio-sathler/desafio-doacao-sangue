package com.doacao.sague.model.dto;


import com.doacao.sague.model.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PercetageObeseByGenderDTO {

    private GenderEnum gender;
    private String percentageOverWeight;

}
