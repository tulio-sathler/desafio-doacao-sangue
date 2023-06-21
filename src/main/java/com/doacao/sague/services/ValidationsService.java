package com.doacao.sague.services;

import br.com.caelum.stella.validation.CPFValidator;
import com.doacao.sague.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ValidationsService {
    private final CPFValidator cpfValidator;
    public void cpfValidator(String cpf) {
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new BadRequestException(String.format("Cpf inválido: %s", cpf));
        }
    }

    public void validateEmails(String email) {
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (Exception e) {
            throw new BadRequestException(String.format("Email invalido: %s", email));
        }

    }

    public void inputNonNull(Object input, String parameter) {
        if (Objects.isNull(input)) {
            throw new BadRequestException(String.format("Parametro %s não pode ser nulo", parameter));
        }
    }


}
