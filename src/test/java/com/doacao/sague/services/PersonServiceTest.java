package com.doacao.sague.services;

import com.doacao.sague.exception.BadRequestException;
import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.mapper.PersonMapper;
import com.doacao.sague.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @Test
    void testSaveAllSucess() {
        Person person = personBuilder(MOCK_CPF);
        PersonDTO personDTO = personDTOBuilder(MOCK_CPF);
        List<Person> personList = List.of(person);
        List<PersonDTO> personBuilderDTO = List.of(personDTO);


        when(repository.saveAll(anyList())).thenReturn(personList);
        when(mapper.toPessoa(any())).thenReturn(person);
        when(mapper.toPessoaDTO(any())).thenReturn(personDTO);

        List<PersonDTO> listPersonDTO = target.saveAll(personBuilderDTO);

        verify(repository, times(1)).saveAll(anyList());
        verify(mapper, times(1)).toPessoa(any(PersonDTO.class));
        verify(mapper, times(1)).toPessoaDTO(any(Person.class));

        for (int i = 0; i < listPersonDTO.size(); i++) {
            assertEquals(personBuilderDTO.get(i).getCpf(), listPersonDTO.get(i).getCpf());
        }

    }

    @Test
    void testSaveAllSucessMoreThanOneElement() {
        Person person = personBuilder(MOCK_CPF);
        PersonDTO personDTO = personDTOBuilder(MOCK_CPF);
        List<Person> personList = List.of(person, person);
        List<PersonDTO> personBuilderDTO = List.of(personDTO, personDTO);


        when(repository.saveAll(anyList())).thenReturn(personList);
        when(mapper.toPessoa(any())).thenReturn(person);
        when(mapper.toPessoaDTO(any())).thenReturn(personDTO);

        List<PersonDTO> listPersonDTO = target.saveAll(personBuilderDTO);

        verify(repository, times(1)).saveAll(anyList());
        verify(mapper, times(2)).toPessoa(any(PersonDTO.class));
        verify(mapper, times(2)).toPessoaDTO(any(Person.class));

        for (int i = 0; i < listPersonDTO.size(); i++) {
            assertEquals(personBuilderDTO.get(i).getCpf(), listPersonDTO.get(i).getCpf());
        }

    }


}
