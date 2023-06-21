package com.doacao.sague.repository;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.query.BloodTypeQueryDTO;
import com.doacao.sague.model.enums.BloodTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodTypeRepository extends JpaRepository<Person, String> {

    @Query("Select new com.doacao.sague.model.dto.query.BloodTypeQueryDTO(p.tipoSanguineo, AVG(TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()))) from Person p group by p.tipoSanguineo")
    List<BloodTypeQueryDTO> averageAgeByBlood();

    @Query("Select count(*) from Person p where p.tipoSanguineo in (:donatorsList) and TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) between 16 and 69 and p.peso > 50")
    Integer numberOfDonatorsByBloodType(@Param("donatorsList") List<BloodTypeEnum> donatorsList );

}
