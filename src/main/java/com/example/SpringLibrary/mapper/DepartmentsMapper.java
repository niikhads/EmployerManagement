package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.entity.Departments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface DepartmentsMapper {
    DepartmentsMapper INSTANCE = Mappers.getMapper(DepartmentsMapper.class);

    List<DepartmentsResponse> toDepartmentResponseList(List<Departments> departmentsList);
    DepartmentsResponse toDepartmentResponse(Departments departments);

    @Mapping(target = "createdAtd", expression = "java(LocalDateTime.now())")
    Departments toDepartment(DepartmentsRequest departmentsRequest);

    @Mapping(target = "updatedAtd", expression = "java(LocalDateTime.now())")
    Departments toDepartmentById(Long departmentId, DepartmentsRequest departmentsRequest);



}
