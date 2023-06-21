package com.doacao.sague.model.dto;

import com.doacao.sague.model.enums.BloodTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BloodTypeDTO {

    private BloodTypeEnum bloodType;

    private String averageAge;

}
