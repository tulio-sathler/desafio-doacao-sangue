package com.doacao.sague.services;

import com.doacao.sague.exception.BadRequestException;
import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.model.dto.query.PersonByStateDTO;
import com.doacao.sague.model.mapper.PersonMapper;
import com.doacao.sague.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    private ValidationsService validations;

    public List<PersonDTO> saveAll(List<PersonDTO> peopleDTO) {
        if(peopleDTO == null || peopleDTO.isEmpty()) {
            throw new BadRequestException("Lista de pessoas está vazia");
        }

        List<Person> people = convertAndValidatePerson(peopleDTO);

        List<String> cpf = people.stream().map((person) -> person.getCpf()).collect(Collectors.toList());
        List<String> rg = people.stream().map((person) -> person.getRg()).collect(Collectors.toList());

        List<Person> existingPeople = personRepository.findByCpfOrRg(rg, cpf);

        people.removeAll(existingPeople);

        List<Person> savedPeople = personRepository.saveAll(people);

        // convertendo a lista de pessoas salvas para um DTO mais apresentavel ao front
        // podendo remover campos que possuem informações sensiveis.
        log.info("{} pessoas foram salvas, {} pessoas ja existiam", savedPeople.size(), existingPeople.size());

        return savedPeople.stream().map(
                person -> personMapper.toPessoaDTO(person)
        ).collect(Collectors.toList());

    }

    public List<PersonByStateDTO> amountPeopleByState() {
        return personRepository.amountOfPeopleByState();
    }

    private List<Person> convertAndValidatePerson(List<PersonDTO> peopleDTO){
        List<Person> listPeople = peopleDTO.stream().map(
                personDTO -> personMapper.toPessoa(personDTO)
        ).collect(Collectors.toList());

        listPeople.stream().forEach((person) -> {
            validations.cpfValidator(person.getCpf());
            validations.validateEmails(person.getEmail());
            validations.inputNonNull(person.getTelefoneFixo(), "Telefone Fixo");
            validations.inputNonNull(person.getDataNascimento(), "Data de Nascimento");
            validations.inputNonNull(person.getTipoSanguineo(), "Tipo Sanguineo");
        });

        return listPeople;
    }

   }
