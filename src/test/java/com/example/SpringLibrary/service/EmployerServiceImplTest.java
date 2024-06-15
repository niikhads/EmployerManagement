//package com.example.SpringLibrary.service;
//
//
//import com.example.SpringLibrary.mapper.EmployerMapper;
//import com.example.SpringLibrary.model.dto.response.EmployerResponse;
//import com.example.SpringLibrary.model.entity.Employer;
//import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
//import com.example.SpringLibrary.repository.EmployerMyBatisRepo;
//import com.example.SpringLibrary.service.impl.EmployerImplService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.awt.*;
//import java.util.List;
//
//
//
//@ExtendWith(MockitoExtension.class)
//
//public class EmployerServiceImplTest {
//    @Mock
//    private EmployerMyBatisRepo employerMyBatisRepo;
//    @Mock
//    private EmployerMapper employerMapper;
//
//    @InjectMocks
//    private EmployerImplService employerService;
//
//
//    @Test
//    void getAllEmployer_SuccessTest() {
//
//        //given
//        Employer employer = Employer.builder()
//                .employerId(1L)
//                .name("Niki")
//                .surname("Huseynli")
//                .email("priyin13@gmail.com")
//                .status("active")
//                .build();
//
//        List<Employer> connectWrapperList = List.of(employer);
//
//        EmployerResponse employerResponse = EmployerResponse.builder()
//                .employerId(1L)
//                .name("Niki")
//                .surname("Huseynli")
//                .email("priv13@gmail.com")
//                .status("active")
//                .build();
//        List<EmployerResponse> expected = List.of(employerResponse);
//
//
//        //when
//        when(employerMyBatisRepo.findAll()).thenReturn(connectWrapperList);
//        when(employerMapper.toEmployerResponseList(connectWrapperList)).thenReturn(expected);
//
//
//        //then
//        List<EmployerResponse> actual = employerService.getAllEmployers();
//
//
//        assertEquals(expected, actual);
//
//        verify(employerMyBatisRepo, times(2)).findAll();
//        verify(employerMapper, times(1)).toEmployerResponseList(connectWrapperList);
//        verifyNoMoreInteractions(employerMyBatisRepo, employerMapper);
//        //    verifyNoInteractions(employerMyBatisRepo);
//    }
////    @Test
////    void getAllEmployersTest_WhenEmployersIsNull_ThenThrowsCommonException(){
////
////
////    }
//
//
//}