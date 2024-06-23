package com.example.SpringLibrary.model.dto.request;

import com.example.SpringLibrary.model.entity.Departments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionRequest {

    private String positionName;
    private Integer salary;
    private Long departmentId;
    private LocalDateTime createdAtp;
    private LocalDateTime updatedAtp;
   // private Long departmentId;

}
