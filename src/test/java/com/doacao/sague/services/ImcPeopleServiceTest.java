package com.doacao.sague.services;

import com.doacao.sague.constants.ConstantsTest;
import com.doacao.sague.model.dto.ImcByAgeDTO;
import com.doacao.sague.model.dto.query.ImcQueryDTO;
import com.doacao.sague.model.dto.PercetageObeseByGenderDTO;
import com.doacao.sague.model.enums.GenderEnum;
import com.doacao.sague.model.mapper.ImcMapper;
import com.doacao.sague.repository.ImcPeopleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ImcPeopleServiceTest {

    @Mock
    private ImcMapper imcMapper;

    @Mock
    private ImcPeopleRepository imcPeopleRepository;

    @InjectMocks
    private ImcPeopleService target;

    // ############################################################################################
    // ################################# imcAverageAgePeople ###################################
    // ############################################################################################
    @Test
    void imcAverageAgePeopleTestEmptyList() {
        when(imcPeopleRepository.averageAgeImc()).thenReturn(List.of());

        List<ImcByAgeDTO> imc = target.imcAverageAgePeople();

        assertEquals(0, imc.size());
        verify(imcPeopleRepository, times(1)).averageAgeImc();
        verify(imcMapper, times(0)).toImcByAgeDTO(any());
    }

    @Test
    void imcAverageAgePeopleTestSucess() {
        List<ImcQueryDTO> queryResult = List.of(ConstantsTest.imcQueryDTOBuilder(0, 32.145651654));
        List<ImcByAgeDTO> mapperResult = List.of(ConstantsTest.imcByAgeBuilder("0-10", "32.14"));
        when(imcPeopleRepository.averageAgeImc()).thenReturn(queryResult);

        for (int i = 0; i < queryResult.size(); i++) {
            when(imcMapper.toImcByAgeDTO(queryResult.get(i))).thenReturn(mapperResult.get(i));
        }

        List<ImcByAgeDTO> imc = target.imcAverageAgePeople();

        verify(imcPeopleRepository, times(1)).averageAgeImc();
        for (int i = 0; i < queryResult.size(); i++) {
            verify(imcMapper, times(1)).toImcByAgeDTO(queryResult.get(i));
        }

        assertEquals(1, imc.size());
        assertEquals("0-10", imc.get(0).getDateRange());
        assertEquals("32.14", imc.get(0).getImc());
    }

    @Test
    void imcAverageAgePeopleTestMultipleResultsSucess() {
        List<ImcQueryDTO> queryResult = List.of(ConstantsTest.imcQueryDTOBuilder(0, 20.546543246543213), ConstantsTest.imcQueryDTOBuilder(10, 30.65465132456), ConstantsTest.imcQueryDTOBuilder(20, 35.65456132468));
        List<ImcByAgeDTO> mapperResult = List.of(ConstantsTest.imcByAgeBuilder("0-10", "20.54"), ConstantsTest.imcByAgeBuilder("11-20", "30.65"), ConstantsTest.imcByAgeBuilder("21-30", "35.65"));
        when(imcPeopleRepository.averageAgeImc()).thenReturn(queryResult);

        for (int i = 0; i < queryResult.size(); i++) {
            when(imcMapper.toImcByAgeDTO(queryResult.get(i))).thenReturn(mapperResult.get(i));
        }

        List<ImcByAgeDTO> imc = target.imcAverageAgePeople();

        verify(imcPeopleRepository, times(1)).averageAgeImc();

        for (int i = 0; i < imc.size(); i++) {
            verify(imcMapper, times(1)).toImcByAgeDTO(queryResult.get(i));
        }
        assertEquals(3, imc.size());
        assertEquals("0-10", imc.get(0).getDateRange());
        assertEquals("20.54", imc.get(0).getImc());
        assertEquals("11-20", imc.get(1).getDateRange());
        assertEquals("30.65", imc.get(1).getImc());
        assertEquals("21-30", imc.get(2).getDateRange());
        assertEquals("35.65", imc.get(2).getImc());
    }

    // ############################################################################################
    // ################################# percetageObeseByGender ###################################
    // ############################################################################################

    @Test
    void percetageObeseByGenderEmptyList() {
        when(imcPeopleRepository.percentageObeseByGender()).thenReturn(List.of());

        List<PercetageObeseByGenderDTO> percetageObeseByGenderList = target.percetageObeseByGender();
        verify(imcPeopleRepository, times(1)).percentageObeseByGender();
        assertEquals(0, percetageObeseByGenderList.size());
    }


    @Test
    void percetageObeseByGenderWithOneGender() {
        when(imcPeopleRepository.percentageObeseByGender()).thenReturn(List.of(ConstantsTest.overweightPeopleByGenderQueryDTOBuilder(GenderEnum.MASCULINO, 5, 10)));

        List<PercetageObeseByGenderDTO> percetageObeseByGenderList = target.percetageObeseByGender();

        verify(imcPeopleRepository, times(1)).percentageObeseByGender();

        assertEquals(1, percetageObeseByGenderList.size());
        assertEquals(GenderEnum.MASCULINO, percetageObeseByGenderList.get(0).getGender());
        assertEquals("50%", percetageObeseByGenderList.get(0).getPercentageOverWeight());
    }

    @Test
    void percetageObeseByGenderWithMultipleGender() {
        when(imcPeopleRepository.percentageObeseByGender())
                .thenReturn(
                        List.of(
                                ConstantsTest.overweightPeopleByGenderQueryDTOBuilder(GenderEnum.FEMINIMO, 3, 17),
                                ConstantsTest.overweightPeopleByGenderQueryDTOBuilder(GenderEnum.MASCULINO, 8, 23)
                        ));

        List<PercetageObeseByGenderDTO> percetageObeseByGenderList = target.percetageObeseByGender();

        verify(imcPeopleRepository, times(1)).percentageObeseByGender();

        assertEquals(2, percetageObeseByGenderList.size());
        assertEquals(GenderEnum.FEMINIMO, percetageObeseByGenderList.get(0).getGender());
        assertEquals("17,65%", percetageObeseByGenderList.get(0).getPercentageOverWeight());
        assertEquals(GenderEnum.MASCULINO, percetageObeseByGenderList.get(1).getGender());
        assertEquals("34,78%", percetageObeseByGenderList.get(1).getPercentageOverWeight());
    }


    @Test
    void percetageObeseByGenderWithBigData() {
        when(imcPeopleRepository.percentageObeseByGender())
                .thenReturn(
                        List.of(
                                ConstantsTest.overweightPeopleByGenderQueryDTOBuilder(GenderEnum.FEMINIMO, 989889513, 1534320004),
                                ConstantsTest.overweightPeopleByGenderQueryDTOBuilder(GenderEnum.MASCULINO, 65469375, 543356451)
                        ));

        List<PercetageObeseByGenderDTO> percetageObeseByGenderList = target.percetageObeseByGender();

        verify(imcPeopleRepository, times(1)).percentageObeseByGender();

        assertEquals(2, percetageObeseByGenderList.size());
        assertEquals(GenderEnum.FEMINIMO, percetageObeseByGenderList.get(0).getGender());
        assertEquals("64,52%", percetageObeseByGenderList.get(0).getPercentageOverWeight());
        assertEquals(GenderEnum.MASCULINO, percetageObeseByGenderList.get(1).getGender());
        assertEquals("12,05%", percetageObeseByGenderList.get(1).getPercentageOverWeight());
    }
}
