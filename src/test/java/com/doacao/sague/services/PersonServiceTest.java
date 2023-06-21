package com.doacao.sague.services;

import com.doacao.sague.exception.BadRequestException;
import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.dto.query.PersonByStateDTO;
import com.doacao.sague.model.mapper.PersonMapper;
import com.doacao.sague.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.doacao.sague.constants.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @Mock
    private PersonMapper mapper;

    @Mock
    private ValidationsService validationsService;

    @InjectMocks
    private PersonService target;

    @Test
    void testSaveAllWhenPeopleListIsNull() {
       assertThrows(BadRequestException.class, () -> target.saveAll(null));
    }

    @Test
    void testSaveAllWhenPeopleListIsEmpty() {
        assertThrows(BadRequestException.class, () -> target.saveAll(List.of()));
    }

    // ############################################################################################
    // ######################################### saveAll ##########################################
    // ############################################################################################
    @Test
    void testSaveAllSucess() {
        Person person = personBuilder(MOCK_CPF, MOCK_EMAIL, MOCK_TELEFONE_FIXO, MOCK_DATA_NASCIMENTO, MOCK_TIPO_SANGUINEO);
        PersonDTO personDTO = personDTOBuilder(MOCK_CPF, MOCK_EMAIL, MOCK_TELEFONE_FIXO, MOCK_DATA_NASCIMENTO, MOCK_TIPO_SANGUINEO);
        List<Person> personList = List.of(person);
        List<PersonDTO> personBuilderDTO = List.of(personDTO);


        when(repository.saveAll(anyList())).thenReturn(personList);
        when(mapper.toPessoa(any())).thenReturn(person);

        when(mapper.toPessoaDTO(any())).thenReturn(personDTO);
        Mockito.doNothing().when(validationsService).cpfValidator(MOCK_CPF);
        Mockito.doNothing().when(validationsService).validateEmails(MOCK_EMAIL);
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_TELEFONE_FIXO, "Telefone Fixo");
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_DATA_NASCIMENTO, "Data de Nascimento");
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_TIPO_SANGUINEO, "Tipo Sanguineo");

        List<PersonDTO> listPersonDTO = target.saveAll(personBuilderDTO);

        assertEquals(1, listPersonDTO.size());

        verify(repository, times(1)).saveAll(anyList());
        verify(mapper, times(1)).toPessoa(any(PersonDTO.class));
        verify(mapper, times(1)).toPessoaDTO(any(Person.class));

        verify(validationsService, times(1)).cpfValidator(MOCK_CPF);
        verify(validationsService, times(1)).validateEmails(MOCK_EMAIL);
        verify(validationsService, times(1)).inputNonNull(MOCK_TELEFONE_FIXO, "Telefone Fixo");
        verify(validationsService, times(1)).inputNonNull(MOCK_DATA_NASCIMENTO, "Data de Nascimento");
        verify(validationsService, times(1)).inputNonNull(MOCK_TIPO_SANGUINEO, "Tipo Sanguineo");
    }

    @Test
    void testSaveAllSucessMoreThanOneElement() {
        Person person = personBuilder(MOCK_CPF, MOCK_EMAIL, MOCK_TELEFONE_FIXO, MOCK_DATA_NASCIMENTO, MOCK_TIPO_SANGUINEO);
        PersonDTO personDTO = personDTOBuilder(MOCK_CPF, MOCK_EMAIL, MOCK_TELEFONE_FIXO, MOCK_DATA_NASCIMENTO, MOCK_TIPO_SANGUINEO);
        List<Person> personList = List.of(person, person);
        List<PersonDTO> personBuilderDTO = List.of(personDTO, personDTO);


        when(repository.saveAll(anyList())).thenReturn(personList);
        when(mapper.toPessoa(any())).thenReturn(person);
        when(mapper.toPessoaDTO(any())).thenReturn(personDTO);

        Mockito.doNothing().when(validationsService).cpfValidator(MOCK_CPF);
        Mockito.doNothing().when(validationsService).validateEmails(MOCK_EMAIL);
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_TELEFONE_FIXO, "Telefone Fixo");
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_DATA_NASCIMENTO, "Data de Nascimento");
        Mockito.doNothing().when(validationsService).inputNonNull(MOCK_TIPO_SANGUINEO, "Tipo Sanguineo");

        List<PersonDTO> listPersonDTO = target.saveAll(personBuilderDTO);

        assertEquals(2, listPersonDTO.size());

        verify(repository, times(1)).saveAll(anyList());
        verify(mapper, times(2)).toPessoa(any(PersonDTO.class));
        verify(mapper, times(2)).toPessoaDTO(any(Person.class));

        verify(validationsService, times(2)).cpfValidator(MOCK_CPF);
        verify(validationsService, times(2)).validateEmails(MOCK_EMAIL);
        verify(validationsService, times(2)).inputNonNull(MOCK_TELEFONE_FIXO, "Telefone Fixo");
        verify(validationsService, times(2)).inputNonNull(MOCK_DATA_NASCIMENTO, "Data de Nascimento");
        verify(validationsService, times(2)).inputNonNull(MOCK_TIPO_SANGUINEO, "Tipo Sanguineo");


    }
    // ############################################################################################
    // ######################################### saveAll ##########################################
    // ############################################################################################

    @Test
    void testamountPeopleByState() {
        when(repository.amountOfPeopleByState()).thenReturn(List.of(PersonByStateDTO.builder().build()));
        target.amountPeopleByState();
        verify(repository, times(1)).amountOfPeopleByState();
    }
}
