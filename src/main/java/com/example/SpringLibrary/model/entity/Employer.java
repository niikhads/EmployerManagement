package com.example.SpringLibrary.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    private Long employerId;
    private String name;
    private String surname;
    private String email;

    private String status;
    private LocalDateTime createdAte;
    private LocalDateTime updatedAte;
    private Departments departments;

    private Position position;

//    public Departments getDepartments() {
//        return departments;
//    }
}
