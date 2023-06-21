package com.doacao.sague.model.dto;

import com.doacao.sague.model.enums.BloodTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DonatorsDTO {

    private BloodTypeEnum bloodType;

    private Integer donators;
}
