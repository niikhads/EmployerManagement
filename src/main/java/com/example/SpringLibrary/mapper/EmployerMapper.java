package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.request.EmployerRequest;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.model.entity.Employer;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface EmployerMapper {

    EmployerMapper INSTANCE = Mappers.getMapper(EmployerMapper.class);


    @Mapping(target ="departments.departmentId",source="departmentId")
    @Mapping(target ="departments.departmentName",source="departmentName")
    @Mapping(target ="departments.createdAtd",source="createdAtd")
    @Mapping(target ="departments.updatedAtd",source="updatedAtd")
    @Mapping(target ="position.positionId",source="positionId")
    @Mapping(target ="position.positionName",source="positionName")
    @Mapping(target ="position.salary",source="salary")
    @Mapping(target ="position.createdAtp",source="createdAtp")
    @Mapping(target ="position.updatedAtp",source="updatedAtp")
    List<EmployerResponse> toEmployerResponseList(List<ConnectWrapper> connectWrapperList);

    @Mapping(target ="departments.departmentId",source="departmentId")
    @Mapping(target ="position.positionId",source="positionId")
    @Mapping(target =  "createdAte", expression = "java(LocalDateTime.now())")
    Employer toEmployer(EmployerRequest employerRequest);

    @Mapping(target ="departments.departmentId",source="employerRequest.departmentId")
    @Mapping(target ="position.positionId",source="employerRequest.positionId")
    @Mapping(target = "updatedAte", expression = "java(LocalDateTime.now())")
    Employer toEmployerById(Long employerId, EmployerRequest employerRequest);

    @Mapping(target = "departments.departmentId", source = "departmentId")
    @Mapping(target = "departments.departmentName", source = "departmentName")
    @Mapping(target = "departments.createdAtd", source = "createdAtd")
    @Mapping(target = "departments.updatedAtd", source = "updatedAtd")
    @Mapping(target = "position.positionId", source = "positionId")
    @Mapping(target = "position.positionName", source = "positionName")
    @Mapping(target = "position.salary",source="salary")
    @Mapping(target = "position.createdAtp", source = "updatedAtp")
    @Mapping(target = "position.updatedAtp", source = "updatedAtp")
    EmployerResponse toEmployerResp (ConnectWrapper connectWrapper);


    }


