//package com.example.SpringLibrary.controller;
//
//import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
//import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
//import com.example.SpringLibrary.service.DepartmentsService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = DepartmentControllerTest.class)
//@WithMockUser(username = "user",password = "pass")
//public class DepartmentControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @MockBean(name = "departmentServiceImpl")
//    private DepartmentsService departmentsService;
//    @Test
//    private void testGetallDepartment_Success() throws Exception {
//        DepartmentsResponse departmentsResponse=new DepartmentsResponse();
//        departmentsResponse.setDepartmentId(2L);
//        List<DepartmentsResponse> departmentsResponseList = List.of(departmentsResponse);
//
//        DepartmentsResponse.builder().departmentId(2L).departmentName("Security").build();
//
//        //given
//
//        //when
//        when(departmentsService.getAllDepartments()).thenReturn(departmentsResponseList);
//        ///then
//        mockMvc.perform(get("/department/no-auth")
//                )
//                .andExpect(jsonPath("$.[0].departmentId", is(2))
//                )    .andExpect(status().isOk());
//    }
//    @Test
//    private void testAddDepartment_Success() throws Exception {
//        DepartmentsRequest departmentsRequest=DepartmentsRequest.builder().departmentName("IT").build();
//        doNothing().when(departmentsService).addDepartment();departmentsRequest);
//        ///then
//        mockMvc.perform(post("/department")
//                        .with(csrf())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(objectMapper.writeValueAsString(departmentsRequest))
//                )
//                .andExpect(status().isOk());
//    }
//}