//package com.example.SpringLibrary.mapper;
//
//import com.example.SpringLibrary.model.dto.response.EmployerResponse;
//import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class EmployerMapperTest {
//    @Autowired
//    private EmployerMapper employerMapper;
//
//    @Test
//    public void testEmployeeMapper() {
//        ConnectWrapper connectWrapper = ConnectWrapper.builder().employerId()1L).name"John")
//                .surname("Doe").email("johndoe@example.com")
//                .status(1).build();
//        EmployerResponse expected = EmployerResponse.builder().employerId(2L).name("John")
//                .surname("Doe").email("johndoe@gmail.com")
//                .status(1).build();
//        EmployerResponse actual = employerMapper.toEmployerResp(connectWrapper);
//        assertEquals(expected, actual);
//    }
//}
//

