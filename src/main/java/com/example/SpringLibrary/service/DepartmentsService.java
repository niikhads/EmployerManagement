package com.example.SpringLibrary.service;

import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;

import java.util.List;

public interface DepartmentsService {
    List<DepartmentsResponse> getAllDepartments();
    DepartmentsResponse getDepartmentByID(Long departmentId);
    void addDepartment(DepartmentsRequest departmentsRequest);

    void updateDepartment(Long departmentId, DepartmentsRequest departmentsRequest);
    void deleteDepartment(Long departmentId);
}
