package com.example.SpringLibrary.controller;

import com.example.SpringLibrary.model.dto.request.DepartmentsRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {


    private final DepartmentsService departmentsService;


    @GetMapping
    public ResponseEntity<List<DepartmentsResponse>> getAllDepartments() {
        List<DepartmentsResponse> departments = departmentsService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("departmentId/{departmentId}")
    public ResponseEntity<DepartmentsResponse> getDepartmentByID(@PathVariable("departmentId") Long departmentId) {
        DepartmentsResponse department = departmentsService.getDepartmentByID(departmentId);
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Void> addDepartment(@RequestBody DepartmentsRequest departmentsRequest) {
        departmentsService.addDepartment(departmentsRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/departmentId/{departmentId}")
    public ResponseEntity<Void> updateDepartment(@PathVariable Long departmentId,
                                                 @RequestBody DepartmentsRequest departmentsRequest) {
        departmentsService.updateDepartment(departmentId, departmentsRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/departmentId/{departmentId}")
    public ResponseEntity<Void> deleteDepartmentByID(@PathVariable Long departmentId) {
        departmentsService.deleteDepartment(departmentId);
        return ResponseEntity.ok().build();
    }

}
