package com.doacao.sague.constants;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.ImcByAgeDTO;
import com.doacao.sague.model.dto.query.ImcQueryDTO;
import com.doacao.sague.model.dto.PercetageObeseByGenderDTO;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.dto.query.OverweightPeopleByGenderQueryDTO;
import com.doacao.sague.model.enums.BloodTypeEnum;
import com.doacao.sague.model.enums.GenderEnum;
import com.doacao.sague.model.enums.StatesEnum;

import java.util.Date;

public class ConstantsTest {

    public static final String MOCK_CPF = "12345678901";
    public static final String MOCK_RG = "123456789";
    public static final String MOCK_CEP = "30458127";
    public static final String MOCK_EMAIL = "teste@teste.com";
    public static final String MOCK_CELULAR = "31996589520";
    public static final String MOCK_TELEFONE_FIXO = "33335555";
    public static final String MOCK_BAIRRO = "buritis";
    public static final String MOCK_CIDADE = "belo horizonte";
    public static final String MOCK_ENDERECO = "Av contorno";
    public static final Integer MOCK_NUMERO = 323;
    public static final Double MOCK_ALTURA = 1.69;
    public static final Double MOCK_PESO = 82.0;
    public static final String MOCK_NOME_PAI = "joao inacio";
    public static final String MOCK_NOME_MAE = "maria jose";
    public static final String MOCK_NOME = "Tulio marques sathler";
    public static final String MOCK_PERCENTAGE_OBECE = "54,98";

    public static final BloodTypeEnum MOCK_TIPO_SANGUINEO = BloodTypeEnum.An;
    public static final Date MOCK_DATA_NASCIMENTO = new Date();


    public static PersonDTO personDTOBuilder(String cpf, String email, String telefoneFixo, Date dataNascimento, BloodTypeEnum tipoSanguineo) {
        return PersonDTO.builder()
                .cpf(cpf)
                .cep(MOCK_CEP)
                .rg(MOCK_RG)
                .email(email)
                .altura(MOCK_ALTURA)
                .celular(MOCK_CELULAR)
                .cidade(MOCK_CIDADE)
                .nome(MOCK_NOME)
                .dataNascimento(dataNascimento)
                .bairro(MOCK_BAIRRO)
                .estado(StatesEnum.AC)
                .peso(MOCK_PESO)
                .sexo(GenderEnum.MASCULINO)
                .mae(MOCK_NOME_MAE)
                .pai(MOCK_NOME_PAI)
                .endereco(MOCK_ENDERECO)
                .numero(MOCK_NUMERO)
                .telefoneFixo(telefoneFixo)
                .tipoSanguineo(tipoSanguineo)
                .build();
    }

    public static Person personBuilder(String cpf, String email, String telefoneFixo, Date dataNascimento, BloodTypeEnum tipoSanguineo) {
        return Person.builder()
                .cpf(cpf)
                .cep(MOCK_CEP)
                .rg(MOCK_RG)
                .email(email)
                .altura(MOCK_ALTURA)
                .celular(MOCK_CELULAR)
                .cidade(MOCK_CIDADE)
                .nome(MOCK_NOME)
                .dataNascimento(dataNascimento)
                .bairro(MOCK_BAIRRO)
                .estado(StatesEnum.MS)
                .peso(MOCK_PESO)
                .gender(GenderEnum.MASCULINO)
                .mae(MOCK_NOME_MAE)
                .pai(MOCK_NOME_PAI)
                .endereco(MOCK_ENDERECO)
                .numero(MOCK_NUMERO)
                .telefoneFixo(telefoneFixo)
                .tipoSanguineo(tipoSanguineo)
                .build();
    }

    public static ImcByAgeDTO imcByAgeBuilder(String range, String imcPercentage) {
        return ImcByAgeDTO
                .builder()
                .imc(imcPercentage)
                .dateRange(range)
                .build();
    }
    public static ImcQueryDTO imcQueryDTOBuilder(Integer range, Double imc) {
        return ImcQueryDTO
                .builder()
                .imc(imc)
                .dateRange(range)
                .build();
    }

    public static OverweightPeopleByGenderQueryDTO overweightPeopleByGenderQueryDTOBuilder(GenderEnum gender, Integer overWeight, Integer total) {
        return new OverweightPeopleByGenderQueryDTO(gender, total, overWeight);
    }

    public static PercetageObeseByGenderDTO percetageObeseByGenderBuilder() {
        return PercetageObeseByGenderDTO
                .builder()
                .percentageOverWeight(MOCK_PERCENTAGE_OBECE)
                .gender(GenderEnum.MASCULINO)
                .build();
    }

}
