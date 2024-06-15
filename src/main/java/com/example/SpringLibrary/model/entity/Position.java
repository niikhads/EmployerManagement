package com.example.SpringLibrary.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private  Long positionId;
    private String positionName;
    private Integer salary;
    private LocalDateTime createdAtp;
    private LocalDateTime updatedAtp;
    private Departments departments;
 //   private Long departmentId;

}
