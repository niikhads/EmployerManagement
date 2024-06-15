package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.request.PositionRequest;
import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;



@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);


    @Mapping(target ="departments.departmentId",source="departmentId")
    @Mapping(target ="departments.departmentName",source="departmentName")
    @Mapping(target ="departments.createdAtd",source="createdAtd")
    @Mapping(target ="departments.updatedAtd",source="updatedAtd")
    List<PositionResponse> toPositionList(List<ConnectPos> connectPosList);


    @Mapping(target ="departments.departmentId",source="departmentId")
    @Mapping(target ="departments.departmentName",source="departmentName")
    @Mapping(target ="departments.createdAtd",source="createdAtd")
    @Mapping(target ="departments.updatedAtd",source="updatedAtd")
    PositionResponse toPositionResponse(ConnectPos connectPos);


    @Mapping(target = "createdAtp", expression = "java(LocalDateTime.now())")
    Position  toPosition(PositionRequest positionRequest);
    @Mapping(target = "updatedAtp", expression = "java(LocalDateTime.now())")
    Position toPositionById(Long positionId, PositionRequest positionRequest );

}
