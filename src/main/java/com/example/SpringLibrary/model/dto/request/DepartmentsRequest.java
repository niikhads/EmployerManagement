package com.example.SpringLibrary.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsRequest {
    private String departmentName;
       private LocalDateTime creadetAtd;
  //  private LocalDateTime updatedAtd;
}
