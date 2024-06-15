package com.example.SpringLibrary.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class PositionResponse {
    private Long positionId;
    private String positionName;
    private Integer salary;
    private LocalDateTime createdAtp;
    private LocalDateTime updatedAtp;
    private DepartmentsResponse departments;
}
