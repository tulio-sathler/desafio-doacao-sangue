package com.doacao.sague.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    MASCULINO("Masculino"),
    FEMINIMO("Feminino");

    private String gender;

    @JsonCreator
    public static GenderEnum decode(final String gender) {
        return Stream.of(GenderEnum.values())
                .filter(targetEnum -> targetEnum.gender.equals(gender))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public String getGender() {
        return gender;
    }

}
