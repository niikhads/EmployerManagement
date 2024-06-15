package com.example.SpringLibrary.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departments {
    private Long departmentId;
    private String departmentName;
    private LocalDateTime createdAtd;
    private LocalDateTime updatedAtd;

}

