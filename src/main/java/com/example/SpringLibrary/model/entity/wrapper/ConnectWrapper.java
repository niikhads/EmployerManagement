package com.example.SpringLibrary.model.entity.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectWrapper {

    private Long employerId;
    private String name;
    private String surname;
    private String email;
    private String status;
    private LocalDateTime createdAte;
    private LocalDateTime updatedAte;


    private Long departmentId;
    private String departmentName;
    private LocalDateTime createdAtd;
    private LocalDateTime updatedAtd;


    private  Long positionId;
    private String positionName;
    private Integer salary;
    private LocalDateTime createdAtp;
    private LocalDateTime updatedAtp;

}
