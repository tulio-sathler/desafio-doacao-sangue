package com.doacao.sague.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ImcByAgeDTO {

    private String dateRange;

    private String imc;

}
