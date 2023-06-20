package com.doacao.sague.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BloodTypeEnum {

    Ap ("A+"),
    An ("A-"),
    Bp ("B+"),
    Bn ("B-"),
    ABp ("AB+"),
    ABn ("AB-"),
    Op ("O+"),
    On ("O-");

    public String descricao;

}
