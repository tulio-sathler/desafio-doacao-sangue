package com.doacao.sague.model.dto.query;

import com.doacao.sague.model.enums.StatesEnum;
import lombok.Getter;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Getter
@Builder
@EqualsAndHashCode
public class PersonByStateDTO {

    private StatesEnum estado;
    private Integer valor;

    public PersonByStateDTO(StatesEnum estado, Integer valor) {
        this.estado = estado;
        this.valor = valor;
    }
}
