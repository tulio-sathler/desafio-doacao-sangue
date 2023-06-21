package com.doacao.sague.model.dto;

import com.doacao.sague.model.enums.BloodTypeEnum;
import com.doacao.sague.model.enums.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PersonDTO {


    @NonNull
    private String nome;

    @NonNull
    private String cpf;

    @NonNull
    private String rg;

    @JsonProperty("data_nasc")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @NonNull
    private GenderEnum sexo;

    @NonNull
    private String mae;

    @NonNull
    private String pai;

    @NonNull
    private String email;

    @NonNull
    private String cep;

    @NonNull
    private String endereco;

    @NonNull
    private Integer numero;

    @NonNull
    private String bairro;

    @NonNull
    private String cidade;

    @NonNull
    private String estado;

//    @NonNull
    @JsonProperty("telefone_fixo")
    private String telefoneFixo;

    @NonNull
    private String celular;

    @NonNull
    private Double altura;

    @NonNull
    private Double peso;

    //@NonNull
    @JsonProperty("tipo_sanguineo")
    private BloodTypeEnum tipoSanguineo;

}
