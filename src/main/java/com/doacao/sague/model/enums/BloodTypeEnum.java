package com.doacao.sague.model.enums;

import com.doacao.sague.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public enum BloodTypeEnum {

    Ap("A+", Arrays.asList("A+", "A-", "O+", "O-")),
    An("A-", Arrays.asList("A-", "O-")),
    Bp("B+", Arrays.asList("B+", "B-", "O+", "O-")),
    Bn("B-", Arrays.asList("B-", "O-")),
    ABp("AB+", Arrays.asList("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-")),
    ABn("AB-", Arrays.asList("A-", "B-", "AB-", "O+")),
    Op("O+", Arrays.asList("O+", "O-")),
    On("O-", Arrays.asList("O-"));

    private String bloodType;

    private List<String> donators;

    @JsonCreator
    public static BloodTypeEnum decode(final String bloodType) {
        return Stream.of(BloodTypeEnum.values())
                .filter(targetEnum -> targetEnum.bloodType.equals(bloodType))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Tipo Sanguineo Inexistente"));
    }

    @JsonValue
    public String getBloodType() {
        return bloodType;
    }

    public List<BloodTypeEnum> getDonators() {
        return this.donators.stream().map((element) -> BloodTypeEnum.decode(element)).collect(Collectors.toList());
    }

}
