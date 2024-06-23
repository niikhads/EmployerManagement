package com.example.SpringLibrary.controller;


import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.entity.Departments;
import com.example.SpringLibrary.service.DepartmentsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
@WebMvcTest(controllers = DepartmentControllerTest.class)
@WithMockUser(username = "user",password = "password")
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean(name = "DepartmentsImplService")
    private DepartmentsService departmentsService;
    @Test
    public void testGetAllDepartments_Success() throws Exception {
        DepartmentsResponse departmentsResponse= new DepartmentsResponse();
        departmentsResponse.setDepartmentId(2L);
        List<DepartmentsResponse> departmentsResponseList = List.of(departmentsResponse);

        DepartmentsResponse.builder().departmentId(2L).departmentName("Management").build();

        //given

        //when
        when(departmentsService.getAllDepartments()).thenReturn(departmentsResponseList);
        ///then
        mockMvc.perform(get("/departments")
                )
                .andExpect(jsonPath("$.[0].departmentId", is(2))
                )    .andExpect(status().isOk());
    }
    @Test
    public void testGetDepartmentById_Success() throws Exception {
        DepartmentsResponse departmentsResponse = new DepartmentsResponse();
        departmentsResponse.setDepartmentId(2L);
        List<DepartmentsResponse> departmentsResponseList = List.of(departmentsResponse);

        DepartmentsResponse.builder().departmentId(2L).departmentName("Management").build();

        //given

        //when
        when(departmentsService.getDepartmentByID(departmentsResponse.getDepartmentId()))
                .thenReturn((DepartmentsResponse) departmentsResponseList);
        ///then
        mockMvc.perform(get("/departments/no-auth")
                )
                .andExpect(jsonPath("$.[0].departmentId", is(2))
                )    .andExpect(status().isOk());
    }
    @Test
    public void testAddDepartment_Success() throws Exception {
        DepartmentsRequest departmentsRequest = DepartmentsRequest.builder().departmentName("Management").build();
        doNothing().when(departmentsService).addDepartment(departmentsRequest);
        ///then
        mockMvc.perform(post("/departments")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(departmentsRequest))
                )
                .andExpect(status().isOk());
    }
    @Test
    public void testInsertDepartment_Success() throws Exception {
        Departments departments= Departments.builder().departmentId(1L).build();
        DepartmentsRequest departmentsRequest=DepartmentsRequest.builder().departmentName("Management").build();
        doNothing().when(departmentsService).updateDepartment(departments.getDepartmentId(),departmentsRequest);
        mockMvc.perform(put("/departments")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(departments.getDepartmentId()))
                )
                .andExpect(status().isOk());
    }
    @Test

    public void testDeleteDepartment_Success() throws Exception {
        Departments departments= Departments.builder().departmentId(1L).build();
        DepartmentsRequest departmentsRequest=DepartmentsRequest.builder().departmentName("Management").build();
        doNothing().when(departmentsService).deleteDepartment(departments.getDepartmentId());
        mockMvc.perform(delete("/departments")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(departments.getDepartmentId()))
                )
                .andExpect(status().isOk());
    }
}