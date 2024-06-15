//package com.example.SpringLibrary.service;
//
//import com.example.SpringLibrary.mapper.DepartmentsMapper;
//import com.example.SpringLibrary.mapper.EmployerMapper;
//import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
//import com.example.SpringLibrary.model.dto.response.EmployerResponse;
//import com.example.SpringLibrary.model.entity.Departments;
//import com.example.SpringLibrary.model.entity.Employer;
//import com.example.SpringLibrary.repository.DepartmentsMyBatisRepo;
//import com.example.SpringLibrary.repository.EmployerMyBatisRepo;
//import com.example.SpringLibrary.service.impl.DepartmentsImplService;
//import com.example.SpringLibrary.service.impl.EmployerImplService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//
//
//@ExtendWith(MockitoExtension.class)
//public class DepartmentImplServiceTest {
//    @Mock
//    private DepartmentsMyBatisRepo departmentsMyBatisRepo;
//    @Mock
//    private DepartmentsMapper departmentsMapper;
//
//    @InjectMocks
//    private DepartmentsImplService departmentsService;
//
//
//    @Test
//    void getAllDepartments_SuccessTest() {
//
//        //given
//        Departments departments =   Departments.builder()
//                .departmentId(1L)
//                .departmentName("Developer")
//                .build();
//
//        List<Departments> departmentsList = List.of(departments);
//
//        DepartmentsResponse departmentsResponse = DepartmentsResponse.builder()
//                .departmentId(1L)
//                .departmentName("Developer")
//                .build();
//        List<DepartmentsResponse> expected = List.of(departmentsResponse);
//
//
//        //when
//        when(departmentsMyBatisRepo.findAll()).thenReturn(departmentsList);
//        when(departmentsMapper.toDepartmentResponseList(departmentsList)).thenReturn(expected);
//
//
//        //then
//        List<DepartmentsResponse> actual = departmentsService.getAllDepartments();
//
//
//        assertEquals(expected, actual);
//
//        verify(departmentsMyBatisRepo, times(2)).findAll();
//        verify(departmentsMapper, times(1)).toDepartmentResponseList(departmentsList);
//
//        verifyNoMoreInteractions(departmentsMyBatisRepo, departmentsMapper);
//        //    verifyNoInteractions(employerMyBatisRepo);
//    }
//}
