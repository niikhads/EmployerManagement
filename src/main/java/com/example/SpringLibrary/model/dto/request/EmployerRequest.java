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
public class EmployerRequest {

   // private  Long employerId;
    private String name;
    private String surname;
    private String email;
    private Long departmentId;
    private Long positionId;
    private String status;
    private LocalDateTime createdAte;
    private LocalDateTime updatedAte;

}
