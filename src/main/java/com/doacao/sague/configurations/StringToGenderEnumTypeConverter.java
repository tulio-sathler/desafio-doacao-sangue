package com.doacao.sague.configurations;

import com.doacao.sague.interfaces.RequestParameterConverter;
import com.doacao.sague.model.enums.GenderEnum;
import org.springframework.core.convert.converter.Converter;

@RequestParameterConverter
public class StringToGenderEnumTypeConverter implements Converter<String, GenderEnum> {
    @Override
    public GenderEnum convert(String source) {
        return GenderEnum.decode(source);

    }

}
