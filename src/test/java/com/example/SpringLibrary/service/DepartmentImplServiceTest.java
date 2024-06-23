package com.example.SpringLibrary.service;

import com.example.SpringLibrary.mapper.DepartmentsMapper;
import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.entity.Departments;
import com.example.SpringLibrary.repository.DepartmentsMyBatisRepo;
import com.example.SpringLibrary.service.impl.DepartmentsImplService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DepartmentImplServiceTest {
    @Mock
    private DepartmentsMyBatisRepo departmentsMyBatisRepo;

    @InjectMocks
    private DepartmentsImplService departmentsImplService;
    @Mock
    private DepartmentsMapper departmentsMapper;

    @Test
    void getAllDepartments_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        Departments tests = Departments.builder().departmentId(1L).departmentName("Sales").build();
        List<Departments> departmentsList = List.of(tests);

        DepartmentsResponse departmentsResponse =
                DepartmentsResponse.builder().departmentId(1L).departmentName("Sales").createdAtd(dateTime).build();
        List<DepartmentsResponse> excepted = List.of(departmentsResponse);
        List<DepartmentsResponse> wrongExpected = List.of();

        //when
        when(departmentsMyBatisRepo.findAll()).thenReturn(departmentsList);
        when(departmentsMapper.toDepartmentResponseList(departmentsList)).thenReturn(excepted);

        //then
        List<DepartmentsResponse> actual = departmentsImplService.getAllDepartments();
        assertEquals(excepted, actual);
        verify(departmentsMyBatisRepo, times(1)).findAll();
        verify(departmentsMapper, times(1)).toDepartmentResponseList(departmentsList);
        verifyNoMoreInteractions(departmentsMapper, departmentsMyBatisRepo);
    }

    @Test
    void getDepartmentsById_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        Departments tests = Departments.builder().departmentId(1L).departmentName("Sales").build();
        Optional<Departments> departmentsOptional = Optional.of(tests);

        DepartmentsResponse departmentsResponse =
                DepartmentsResponse.builder().departmentId(1L).departmentName("Sales")
                        .createdAtd(dateTime).build();
        DepartmentsResponse excepted = new DepartmentsResponse();

        //when
        when(departmentsMyBatisRepo.findAll(departmentsResponse.getDepartmentId())).thenReturn(departmentsOptional);
        when(departmentsMapper.toDepartmentResponse(tests)).thenReturn(departmentsResponse);

        //then
        DepartmentsResponse actual = departmentsImplService.getDepartmentByID(departmentsResponse.getDepartmentId());
        assertEquals(excepted, actual);
        verify(departmentsMyBatisRepo, times(1)).findAll(departmentsResponse.getDepartmentId());
        verify(departmentsMapper, times(1)).toDepartmentResponse(tests);
        verifyNoMoreInteractions(departmentsMapper, departmentsMyBatisRepo);
    }

    @Test
    void getAddDepartments_Success() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        Departments test = Departments.builder().departmentId(1L).departmentName("Sales").build();
        DepartmentsRequest departmentsRequest =
                DepartmentsRequest.builder().departmentName("Sales")
                        .creadetAtd(dateTime).build();
        //when
        doNothing().when(departmentsMyBatisRepo).insert(test);
        when(departmentsMapper.toDepartment(departmentsRequest)).thenReturn(test);

        //then
        departmentsImplService.addDepartment(departmentsRequest);

        verify(departmentsMyBatisRepo, times(1)).insert(test);
        verify(departmentsMapper, times(1)).toDepartment(departmentsRequest);
        verifyNoMoreInteractions(departmentsMapper, departmentsMyBatisRepo);
    }

    @Test
    void getUpdateDep_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        Departments test = Departments.builder().departmentId(1L).departmentName("Sales").build();
        DepartmentsRequest departmentsRequest =
                DepartmentsRequest.builder().departmentName("Sales")
                        .creadetAtd(dateTime).build();
        //when
        doNothing().when(departmentsMyBatisRepo).update(test);
        when(departmentsMapper.toDepartmentById(test.getDepartmentId(), departmentsRequest)).thenReturn(test);

        //then
        departmentsMyBatisRepo.update(test.getDepartmentId(), departmentsRequest);

        verify(departmentsMyBatisRepo, times(1)).update(test);
        verify(departmentsMapper, times(1)).toDepartmentById(test.getDepartmentId(), departmentsRequest);
        verifyNoMoreInteractions(departmentsMapper, departmentsMyBatisRepo);
    }
@Test
    void get_deleteDepartmentSuccess() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        Departments test = Departments.builder().departmentId(1L).departmentName("Sales").build();
        //when
        doNothing().when(departmentsMyBatisRepo).delete(test.getDepartmentId());
        //then
        departmentsImplService.deleteDepartment(test.getDepartmentId());
        verify(departmentsMyBatisRepo, times(1)).delete(test.getDepartmentId());
        verifyNoMoreInteractions(departmentsMapper, departmentsMyBatisRepo);
    }
}