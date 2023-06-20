package com.doacao.sague.model.mapper;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPessoa(PersonDTO personDTO);

    PersonDTO toPessoaDTO(Person person);

}
