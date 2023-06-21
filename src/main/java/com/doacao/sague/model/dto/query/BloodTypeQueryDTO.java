package com.doacao.sague.model.dto.query;

import com.doacao.sague.model.enums.BloodTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class BloodTypeQueryDTO {

    private BloodTypeEnum bloodType;

    private Double averageAge;
}
