package com.example.SpringLibrary.service;


import com.example.SpringLibrary.mapper.EmployerMapper;
import com.example.SpringLibrary.model.dto.request.EmployerRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.Departments;
import com.example.SpringLibrary.model.entity.Employer;
import com.example.SpringLibrary.model.entity.Position;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import com.example.SpringLibrary.repository.EmployerMyBatisRepo;
import com.example.SpringLibrary.service.impl.EmployerImplService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



@ExtendWith(MockitoExtension.class)

public class EmployerServiceImplTest {
    @Mock
    private EmployerMyBatisRepo employerMyBatisRepo;

    @InjectMocks
    private EmployerImplService employerImplService;
    @Mock
    private EmployerMapper employerMapper;

    @Test
    void getAllEmployer_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        ConnectWrapper tests = ConnectWrapper
                .builder()
                .employerId(1L)
                .name("John")
                .surname("Doe")
                .email("johndoe@gmail.com")
                .status("active")
                .build();
        List<ConnectWrapper> employerList = List.of(tests);

        EmployerResponse employerResponse =
                EmployerResponse
                        .builder()
                        .name("John")
                        .surname("Doe")
                        .email("johndoe@gmail.com")
                        .status("active")
                        .position(new PositionResponse())
                        .departments(new DepartmentsResponse())
                        .build();
        List<EmployerResponse> excepted = List.of(employerResponse);
        //when
        when(employerMyBatisRepo.findAll()).thenReturn(employerList);
        when(employerMapper.toEmployerResponseList(employerList)).thenReturn(excepted);

        //then
        List<EmployerResponse> actual = employerImplService.getAllEmployers();
        assertEquals(excepted, actual);
        verify(employerMyBatisRepo, times(1)).findAll();
        verify(employerMapper, times(1)).toEmployerResponseList(employerList);
        verifyNoMoreInteractions(employerMapper, employerMyBatisRepo);
    }

    void getByIdEmp_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        ConnectWrapper tests = ConnectWrapper
                .builder()
                .employerId(1L)
                .name("John")
                .surname("Doe")
                .email("johndoe@gmail.com")
                .status("active")
                .build();
        List<ConnectWrapper> employerList = List.of(tests);

        EmployerResponse employerResponse =
                EmployerResponse
                        .builder()
                        .name("John")
                        .surname("Doe")
                        .email("johndoe@gmail.com")
                        .status("active")
                        .position(new PositionResponse())
                        .departments(new DepartmentsResponse())
                        .build();
        List<EmployerResponse> excepted = List.of(employerResponse);
        //when
        when(employerMyBatisRepo.findByEmployerID(employerResponse.getEmployerId())).thenReturn(tests);
        when(employerMapper.toEmployerResp(tests)).thenReturn(employerResponse);

        //then
        EmployerResponse actual = employerImplService.getEmployerByID(employerResponse.getEmployerId());
        assertEquals(excepted, actual);
        verify(employerMyBatisRepo, times(1)).findByEmployerID(employerResponse.getEmployerId());
        verify(employerMapper, times(1)).toEmployerResp(tests);
        verifyNoMoreInteractions(employerMapper, employerMyBatisRepo);
    }

    @Test
    void getAddEmployer_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Employer test= Employer
                .builder()
                .name("John")
                .surname("Doe")
                .email("johndoe@gmail.com")
                .status("active")
                .position(new Position())
                .departments(new Departments())
                .build();
        EmployerRequest employerRequest=
                EmployerRequest.builder()
                        .name("John")
                        .surname("Doe")
                        .email("johndoe@gmail.com")
                        .status("active")
                        .departmentId(1L)
                        .positionId(1L)
                        .build();
        //when
        doNothing().when(employerMyBatisRepo).insert(test);
        when(employerMapper.toEmployer(employerRequest)).thenReturn(test);

        //then
        employerImplService.addEmployer(employerRequest);

        verify(employerMyBatisRepo,times(1)).insert(test);
        verify(employerMapper,times(1)).toEmployer(employerRequest);
        verifyNoMoreInteractions(employerMapper,employerMyBatisRepo);
    }

    @Test
    void getUpdateEmp_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Employer test= Employer
                .builder()
                .employerId(1L)
                .name("John")
                .surname("Doe")
                .email("johndoe@gmail.com")
                .status("active")
                .departments(new Departments())
                .position(new Position())
                .build();
        EmployerRequest employerRequest=
                EmployerRequest.builder()
                        .name("John")
                        .surname("Doe")
                        .status("active")
                        .departmentId(1L)
                        .positionId(1L)
                        .build();
        //when
        doNothing().when(employerMyBatisRepo).update(test);
        when(employerMapper.toEmployerById(test.getEmployerId(),employerRequest)).thenReturn(test);

        //then
        employerImplService.updateEmployer(test.getEmployerId(),employerRequest);

        verify(employerMyBatisRepo,times(1)).update(test);
        verify(employerMapper,times(1)).toEmployerById(test.getEmployerId(),employerRequest);
        verifyNoMoreInteractions(employerMapper,employerMyBatisRepo);
    }

    @Test
    void get_deleteEmployerSuccess(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Employer test= Employer
                .builder()
                .employerId(1L)
                .name("John")
                .surname("Doe")
                .status("active")
                .departments(new Departments())
                .position(new Position())
                .build();
        //when
        doNothing().when(employerMyBatisRepo).delete(test.getEmployerId());
        //then
        employerImplService.deleteEmployer(test.getEmployerId());

        verify(employerMyBatisRepo,times(1)).delete(test.getEmployerId());
        verifyNoMoreInteractions(employerMapper,employerMyBatisRepo);
    }

}