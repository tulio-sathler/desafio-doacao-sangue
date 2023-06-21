package com.doacao.sague.services;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.doacao.sague.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static com.doacao.sague.constants.ConstantsTest.MOCK_CPF;
import static com.doacao.sague.constants.ConstantsTest.MOCK_EMAIL;


@ExtendWith(MockitoExtension.class)
public class ValidationsServiceTest {

    @Mock
    private CPFValidator cpfValidator;

    @InjectMocks
    private ValidationsService target;


    // ############################################################################################
    // ####################################### cpfValidator #######################################
    // ############################################################################################

    @Test
    void cpfValidatorSucess() {
        Mockito.doNothing().when(cpfValidator).assertValid(MOCK_CPF);

        target.cpfValidator(MOCK_CPF);
        Mockito.verify(cpfValidator, times(1)).assertValid(MOCK_CPF);
    }

    @Test
    void cpfValidatorError() {
        Mockito.doThrow(InvalidStateException.class).when(cpfValidator).assertValid(MOCK_CPF);

        Assertions.assertThrows(BadRequestException.class, () -> target.cpfValidator(MOCK_CPF));
        Mockito.verify(cpfValidator, times(1)).assertValid(MOCK_CPF);
    }

    // ############################################################################################
    // ####################################### cpfValidator #######################################
    // ############################################################################################

    @Test
    void validateEmailsSucess() {
        target.validateEmails(MOCK_EMAIL);
    }

    @Test
    void validateEmailsError() {
        Assertions.assertThrows(BadRequestException.class, ()-> target.validateEmails(MOCK_EMAIL.concat("@")));

    }


    // ############################################################################################
    // ############################### inputNonNull ################################
    // ############################################################################################

    @Test
    void inputNonNullSucess() {
        target.inputNonNull(12, "field");
    }

    @Test
    void inputNonNullError() {
        Assertions.assertThrows(BadRequestException.class, ()-> target.inputNonNull(null, "field"));
    }

}
