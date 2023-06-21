package com.doacao.sague.model.mapper;

import com.doacao.sague.model.dto.BloodTypeDTO;
import com.doacao.sague.model.dto.query.BloodTypeQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BloodTypeMapper {

    @Mapping(source = "value", target = "averageAge", numberFormat = "#.00")
    BloodTypeDTO toBloodTypeDTO(BloodTypeQueryDTO bloodTypeQueryDTO);

}
