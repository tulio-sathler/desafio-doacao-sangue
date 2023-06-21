package com.doacao.sague.model.dto.query;


import lombok.*;

@Getter
@Builder
@EqualsAndHashCode
public class PersonByStateDTO {
   private String estado;
   private Integer valor;

   public PersonByStateDTO(String estado, Integer valor) {
      this.estado = estado;
      this.valor = valor;
   }
}
