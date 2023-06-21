package com.doacao.sague.repository;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.query.PersonByStateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    @Query("SELECT new com.doacao.sague.model.dto.query.PersonByStateDTO(p.estado, CAST(count(*) as Integer) as valor) FROM Person p GROUP BY p.estado")
    List<PersonByStateDTO> amountOfPeopleByState();

}
