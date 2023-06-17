package com.doacao.sague.services;

import com.doacao.sague.exception.BadRequestException;
import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.mapper.PersonMapper;
import com.doacao.sague.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public List<PersonDTO> saveAll(List<PersonDTO> people) {
        if(people == null || people.isEmpty()) {
            throw new BadRequestException("Lista de pessoas está vazia");
        }

        List<Person> listPeople = people.stream().map(
                personDTO -> personMapper.toPessoa(personDTO)
        ).collect(Collectors.toList());

        List<Person> savedPeople = personRepository.saveAll(listPeople);

        // convertendo a lista de pessoas salvas para um DTO mais apresentavel ao front
        // podendo remover campos que possuem informações sensiveis.
        // TODO colocar no readme que estou usando comentarios que não precisam para explicar o raciocionio.
        return savedPeople.stream().map(
                person -> personMapper.toPessoaDTO(person)
        ).collect(Collectors.toList());

    }

}
