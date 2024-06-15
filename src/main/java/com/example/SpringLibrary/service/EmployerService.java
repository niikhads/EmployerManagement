package com.example.SpringLibrary.service;

import com.example.SpringLibrary.model.dto.request.EmployerRequest;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;

import java.util.List;

public interface EmployerService {

        List<EmployerResponse> getAllEmployers();
        EmployerResponse getEmployerByID(Long employerId);
        void addEmployer(EmployerRequest employerRequest);
        void updateEmployer(Long employerId, EmployerRequest employerRequest);
        void deleteEmployer(Long employerId);

    }

