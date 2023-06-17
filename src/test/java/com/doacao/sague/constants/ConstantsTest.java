package com.doacao.sague.constants;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.enums.BloodTypeEnum;
import com.doacao.sague.model.enums.GenderEnum;

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
    public static final String MOCK_ESTADO = "Minas Gerais";
    public static final Double MOCK_ALTURA = 1.69;
    public static final Double MOCK_PESO = 82.0;
    public static final String MOCK_NOME_PAI = "joao inacio";
    public static final String MOCK_NOME_MAE = "maria jose";
    public static final String MOCK_NOME = "Tulio marques sathler";


    public static PersonDTO personDTOBuilder(String cpf) {
        return PersonDTO.builder()
                .cpf(cpf)
                .cep(MOCK_CEP)
                .rg(MOCK_RG)
                .email(MOCK_EMAIL)
                .altura(MOCK_ALTURA)
                .celular(MOCK_CELULAR)
                .cidade(MOCK_CIDADE)
                .nome(MOCK_NOME)
                .dataNascimento(new Date())
                .bairro(MOCK_BAIRRO)
                .estado(MOCK_ESTADO)
                .peso(MOCK_PESO)
                .sexo(GenderEnum.MASCULINO)
                .nomeMae(MOCK_NOME_MAE)
                .nomePai(MOCK_NOME_PAI)
                .endereco(MOCK_ENDERECO)
                .numero(MOCK_NUMERO)
                .telefoneFixo(MOCK_TELEFONE_FIXO)
                .tipoSanguineo(BloodTypeEnum.An)
                .build();
    }

    public static Person personBuilder(String cpf) {
        return Person.builder()
                .cpf(cpf)
                .cep(MOCK_CEP)
                .rg(MOCK_RG)
                .email(MOCK_EMAIL)
                .altura(MOCK_ALTURA)
                .celular(MOCK_CELULAR)
                .cidade(MOCK_CIDADE)
                .name(MOCK_NOME)
                .dataNascimento(new Date())
                .bairro(MOCK_BAIRRO)
                .estado(MOCK_ESTADO)
                .peso(MOCK_PESO)
                .sexo(GenderEnum.MASCULINO)
                .nomeMae(MOCK_NOME_MAE)
                .nomePai(MOCK_NOME_PAI)
                .endereco(MOCK_ENDERECO)
                .numero(MOCK_NUMERO)
                .telefoneFixo(MOCK_TELEFONE_FIXO)
                .tipoSanguineo(BloodTypeEnum.An)
                .build();
    }

}
