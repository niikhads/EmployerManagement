//package com.example.SpringLibrary.controller;
//
//import com.example.SpringLibrary.model.dto.request.PositionRequest;
//import com.example.SpringLibrary.model.dto.response.PositionResponse;
//import com.example.SpringLibrary.service.PositionService;
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
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@WebMvcTest(controllers = PositionControllerTest.class)
//@WithMockUser(username = "user",password = "pass")
//public class PositionControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @MockBean(name = "PositionServiceImpl")
//    private PositionService positionService;
//    @Test
//    private void testGetallPosition_Success() throws Exception {
//        PositionResponse positionResponse=new PositionResponse();
//        positionResponse.setPositionId(1L);
//        List<PositionResponse> positionResponseList = List.of(positionResponse);
//
//        PositionResponse.builder().positionId(1L).positionName("Security").build();
//
//        //given
//
//        //when
//        when(positionService.getAllPositions()).thenReturn(positionResponseList);
//        ///then
//        mockMvc.perform(get("/position/no-auth")
//                )
//                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
//                .andExpect(status().isOk());
//    }
//    @Test
//    private void testAddPoistion_Success() throws Exception {
//        PositionRequest positionRequest= PositionRequest.builder().positionName("Security").build();
//        doNothing().when(positionService).addPosition(positionRequest);
//        ///then
//        mockMvc.perform(post("/position")
//                        .with(csrf())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(objectMapper.writeValueAsString(positionRequest))
//                )
//                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
//                .andExpect(status().isOk());
//    }
//}