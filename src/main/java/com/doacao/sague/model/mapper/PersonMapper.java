package com.doacao.sague.model.mapper;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.PersonDTO;
import com.doacao.sague.utils.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", imports = Utils.class)
public interface PersonMapper {

    @Mapping(target = "gender", source = "sexo")
    @Mapping(target = "cpf", expression = "java(Utils.removeNonDigites(personDTO.getCpf()))")
    @Mapping(target = "rg", expression = "java(Utils.removeNonDigites(personDTO.getRg()))")
    @Mapping(target = "celular", expression = "java(Utils.removeNonDigites(personDTO.getCelular()))")
    //@Mapping(target = "telefoneFixo", expression = "java(Utils.removeNonDigites(personDTO.getTelefoneFixo()))")
    @Mapping(target = "cep", expression = "java(Utils.removeNonDigites(personDTO.getCep()))")
    Person toPessoa(PersonDTO personDTO);

    @Mapping(target = "sexo", source = "gender")
    PersonDTO toPessoaDTO(Person person);


}
