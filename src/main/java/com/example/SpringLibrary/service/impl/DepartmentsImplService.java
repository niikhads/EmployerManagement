package com.example.SpringLibrary.service.impl;

import com.example.SpringLibrary.mapper.DepartmentsMapper;
import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.model.entity.Departments;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import com.example.SpringLibrary.repository.DepartmentsMyBatisRepo;
import com.example.SpringLibrary.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentsImplService implements DepartmentsService {

    private final DepartmentsMapper departmentsMapper;
    private final DepartmentsMyBatisRepo departmentsMyBatisRepo;

    @Override
    public List<DepartmentsResponse> getAllDepartments() {
        List<Departments>departments=departmentsMyBatisRepo.findAll();
        List<DepartmentsResponse> departmentResponseList =departmentsMapper.toDepartmentResponseList(departments);
        return departmentResponseList;
    }
    @Override
    public DepartmentsResponse getDepartmentByID(Long departmentId) {
        Optional<Departments> departmentOptional=departmentsMyBatisRepo.findByDepartmentId(departmentId);
        return departmentOptional.map(departmentsMapper::toDepartmentResponse).orElse(null);
    }


    @Override
    public void addDepartment(DepartmentsRequest departmentsRequest) {
        Departments departments = departmentsMapper.toDepartment(departmentsRequest);
        departmentsMyBatisRepo.insert(departments);
    }



    @Override
    public void updateDepartment(Long departmentId, DepartmentsRequest departmentsRequest) {
        Departments departments = departmentsMapper.toDepartmentById(departmentId, departmentsRequest);
        departmentsMyBatisRepo.update(departments);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentsMyBatisRepo.delete(departmentId);

    }
}
