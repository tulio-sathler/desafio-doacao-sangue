package com.doacao.sague.services;

import com.doacao.sague.model.dto.BloodTypeDTO;
import com.doacao.sague.model.dto.query.BloodTypeQueryDTO;
import com.doacao.sague.model.enums.BloodTypeEnum;
import com.doacao.sague.model.mapper.BloodTypeMapper;
import com.doacao.sague.repository.BloodTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BloodTypeServiceTest {

    @Mock
    private BloodTypeMapper mapper;

    @Mock
    private BloodTypeRepository repository;

    @InjectMocks
    private BloodTypeService target;

    @Test
    void averageAgeByBloodSucess() {
        List<BloodTypeQueryDTO> bloodTypeQueryDTOS = List.of(new BloodTypeQueryDTO(BloodTypeEnum.An, 23.434343434));
        when(repository.averageAgeByBlood()).thenReturn(bloodTypeQueryDTOS);
        when(mapper.toBloodTypeDTO(bloodTypeQueryDTOS.get(0))).thenReturn(new BloodTypeDTO(BloodTypeEnum.An, "23.43"));

        var result = target.averageAgeByBlood();

        verify(repository, times(1)).averageAgeByBlood();
        verify(mapper, times(1)).toBloodTypeDTO(bloodTypeQueryDTOS.get(0));

        Assertions.assertEquals("23.43", result.get(0).getAverageAge());
        Assertions.assertEquals(BloodTypeEnum.An, result.get(0).getBloodType());

    }

    @Test
    void averageAgeByBloodMultipleData() {
        List<BloodTypeQueryDTO> bloodTypeQueryDTOS = List.of(new BloodTypeQueryDTO(BloodTypeEnum.An, 23.434343434),
                new BloodTypeQueryDTO(BloodTypeEnum.On, 56.89865656),
                new BloodTypeQueryDTO(BloodTypeEnum.ABn, 77.34243245));

        List<BloodTypeDTO> bloodTypeDTOS = List.of(new BloodTypeDTO(BloodTypeEnum.An, "23.43"),
                new BloodTypeDTO(BloodTypeEnum.On, "56.90"),
                new BloodTypeDTO(BloodTypeEnum.ABn, "77.34"));

        when(repository.averageAgeByBlood()).thenReturn(bloodTypeQueryDTOS);
        when(mapper.toBloodTypeDTO(bloodTypeQueryDTOS.get(0))).thenReturn(bloodTypeDTOS.get(0));
        when(mapper.toBloodTypeDTO(bloodTypeQueryDTOS.get(1))).thenReturn(bloodTypeDTOS.get(1));
        when(mapper.toBloodTypeDTO(bloodTypeQueryDTOS.get(2))).thenReturn(bloodTypeDTOS.get(2));


        var result = target.averageAgeByBlood();

        verify(repository, times(1)).averageAgeByBlood();
        verify(mapper, times(1)).toBloodTypeDTO(bloodTypeQueryDTOS.get(0));
        verify(mapper, times(1)).toBloodTypeDTO(bloodTypeQueryDTOS.get(1));
        verify(mapper, times(1)).toBloodTypeDTO(bloodTypeQueryDTOS.get(2));

        Assertions.assertEquals(3, result.size());

        Assertions.assertEquals("23.43", result.get(0).getAverageAge());
        Assertions.assertEquals(BloodTypeEnum.An, result.get(0).getBloodType());

        Assertions.assertEquals("56.90", result.get(1).getAverageAge());
        Assertions.assertEquals(BloodTypeEnum.On, result.get(1).getBloodType());

        Assertions.assertEquals("77.34", result.get(2).getAverageAge());
        Assertions.assertEquals(BloodTypeEnum.ABn, result.get(2).getBloodType());

    }

    @Test
    void averageAgeByBloodEmptyList() {
        List<BloodTypeQueryDTO> bloodTypeQueryDTOS = List.of();

        when(repository.averageAgeByBlood()).thenReturn(bloodTypeQueryDTOS);

        var result = target.averageAgeByBlood();

        verify(repository, times(1)).averageAgeByBlood();
        verify(mapper, times(0)).toBloodTypeDTO(any());

        Assertions.assertEquals(0, result.size());

    }


}
