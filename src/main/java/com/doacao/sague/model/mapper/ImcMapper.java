package com.doacao.sague.model.mapper;

import com.doacao.sague.model.dto.ImcByAgeDTO;
import com.doacao.sague.model.dto.query.ImcQueryDTO;
import com.doacao.sague.utils.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Utils.class)
public interface ImcMapper {
    @Mapping(target = "dateRange", expression = "java(Utils.range(imcQueryDTO.getDateRange()))")
    @Mapping(source = "imc", target = "imc", numberFormat = "#.00")
    ImcByAgeDTO toImcByAgeDTO(ImcQueryDTO imcQueryDTO);

}
