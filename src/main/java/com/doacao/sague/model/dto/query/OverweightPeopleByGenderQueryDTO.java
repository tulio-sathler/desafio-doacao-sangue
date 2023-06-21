package com.doacao.sague.model.dto.query;

import com.doacao.sague.model.enums.GenderEnum;
import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class OverweightPeopleByGenderQueryDTO {
    private GenderEnum gender;
    private Integer total;
    private Integer overWeight;

}
