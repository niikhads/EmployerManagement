//package com.example.SpringLibrary.mapper;
//
//import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
//import com.example.SpringLibrary.model.entity.Departments;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class DepartmentMapperTest {
//
//        @Autowired
//        private DepartmentsMapper departmentsMapper;
//        @Test
//        public void testDepartmentMapper(){
//            Departments departments= Departments.builder().departmentId(1L).departmentName("Developer").build();
//            DepartmentsResponse expected= DepartmentsResponse.builder().departmentId(1L).departmentName("Developer").build();
//            DepartmentsResponse actual= departmentsMapper.toDepartmentResponse(departments);
//            assertEquals(expected,actual);
//        }
//    }
//
