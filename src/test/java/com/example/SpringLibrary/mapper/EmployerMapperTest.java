package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.Departments;
import com.example.SpringLibrary.model.entity.Position;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class EmployerMapperTest {
    @Autowired
    private EmployerMapper employerMapper;

    @Test
    public void testEmployeeMapper() {
        ConnectWrapper connectWrapper = ConnectWrapper
                .builder()
                .employerId(2L)
                .name("John")
                .surname("Doe")
                .email("johndoe@gmail.com")
                .status("active")
                .build();

        EmployerResponse expected =
                EmployerResponse.builder()
                        .employerId(2L)
                        .name("John")
                        .surname("Doe")
                        .email("johndoe@gmail.com")
                        .status("active")
                        .departments(new DepartmentsResponse())
                        .position(new PositionResponse())
                        .build();
        EmployerResponse actual = employerMapper.toEmployerResp(connectWrapper);
        assertEquals(expected, actual);
    }
}