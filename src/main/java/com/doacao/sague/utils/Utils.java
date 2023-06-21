package com.doacao.sague.utils;

import com.doacao.sague.model.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Utils {

    public static String removeNonDigites(String input) {
        return input.replaceAll("\\D", "");
    }

    public static String range(Integer digito) {
        return String.format("%d-%d", digito == 0 ? digito : digito+1, digito+10);
    }

    public static String formatterNumber(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(number);
    }

    public static String calculatePercentage(BigDecimal number, BigDecimal total) {
        BigDecimal porcentual = number.multiply(BigDecimal.valueOf(100)).divide(total, 2,RoundingMode.HALF_UP);
        return formatterNumber(porcentual).concat("%");
    }
}
