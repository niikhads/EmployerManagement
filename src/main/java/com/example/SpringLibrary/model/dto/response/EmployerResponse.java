package com.example.SpringLibrary.model.dto.response;

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
public class EmployerResponse {
    private  Long employerId;
    private String name;
    private String surname;
    private String email;
    private DepartmentsResponse departments;
    private PositionResponse position;
    private String status;
    private LocalDateTime createdAte;
    private LocalDateTime updatedAte;

}
