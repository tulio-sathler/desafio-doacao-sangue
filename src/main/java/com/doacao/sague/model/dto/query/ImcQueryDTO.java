package com.doacao.sague.model.dto.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class ImcQueryDTO {

    private Integer dateRange;
    private Double imc;

}
