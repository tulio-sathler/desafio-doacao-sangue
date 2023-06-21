package com.doacao.sague.configurations;

import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CpfValidatorBean {

    @Bean
    public CPFValidator getCPFValidator() {
        return new CPFValidator();
    }
}
