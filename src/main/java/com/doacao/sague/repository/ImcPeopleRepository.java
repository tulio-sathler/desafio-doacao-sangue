package com.doacao.sague.repository;

import com.doacao.sague.model.Person;
import com.doacao.sague.model.dto.query.ImcQueryDTO;
import com.doacao.sague.model.dto.query.OverweightPeopleByGenderQueryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImcPeopleRepository extends JpaRepository<Person, String> {

    @Query("""
             SELECT new com.doacao.sague.model.dto.query.ImcQueryDTO(
                 (CASE
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 0 AND 10 THEN 0
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 11 AND 20 THEN 10 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 21 AND 30 THEN 20 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 31 AND 40 THEN 30 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 41 AND 50 THEN 40 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 51 AND 60 THEN 50
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 61 AND 70 THEN 60 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 71 AND 80 THEN 70 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 81 AND 90 THEN 80 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 91 AND 100 THEN 90 
                   WHEN TIMESTAMPDIFF(YEAR, p.dataNascimento, CURDATE()) BETWEEN 101 AND 110 THEN 100 
                   ELSE 110
                  END) as dateRange,
                 AVG(p.peso /(p.altura * p.altura)) as imc
             )
             FROM Person p
             GROUP BY dateRange
             ORDER BY dateRange
           """)
    List<ImcQueryDTO> averageAgeImc();

    @Query("""
            SELECT 
             new com.doacao.sague.model.dto.query.OverweightPeopleByGenderQueryDTO(
              p.gender as gender,
              CAST(count(*) as Integer) AS total,
              CAST(sum(CASE 
                 WHEN (p.peso/(p.altura*p.altura)) > 30 THEN 1
                 ELSE 0
               END) as Integer) AS overWeight)
             FROM Person p
             GROUP BY p.gender 
            """)
    List<OverweightPeopleByGenderQueryDTO> percentageObeseByGender();

    @Query("select p from Person p where rg in :rgList or cpf in :cpfList")
    List<Person> findByCpfOrRg(@Param("rgList") List<String> rgList, @Param("cpfList") List<String> cpfList);

}
