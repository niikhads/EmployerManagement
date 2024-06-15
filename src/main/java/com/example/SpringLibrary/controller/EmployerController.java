package com.example.SpringLibrary.controller;

import com.example.SpringLibrary.model.dto.request.EmployerRequest;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employer")
@RequiredArgsConstructor

public class EmployerController {


        private final EmployerService employerService ;


        @GetMapping
        public ResponseEntity<List<EmployerResponse>> getAllEmployers() {
            List<EmployerResponse> employers = employerService.getAllEmployers();
            return ResponseEntity.ok(employers);
        }

        @GetMapping("employerId/{employerId}")
        public ResponseEntity<EmployerResponse> getEmployerByID(@PathVariable("employerId") Long employerId) {
          EmployerResponse employer = employerService.getEmployerByID(employerId);
            return ResponseEntity.ok(employer);
        }

        @PostMapping
        public ResponseEntity<Void> addEmployer(@RequestBody EmployerRequest employerRequest ) {
            employerService.addEmployer(employerRequest);
            return ResponseEntity.ok().build();
        }

        @PutMapping("/employerId/{employerId}")
        public ResponseEntity<Void> updateEmployer(@PathVariable Long employerId,
                                               @RequestBody EmployerRequest employerRequest ) {
            employerService.updateEmployer(employerId, employerRequest);
            return ResponseEntity.ok().build();
        }

        @DeleteMapping("/employerId/{employerId}")
        public ResponseEntity<Void> deleteEmployerByID(@PathVariable Long employerId){
            employerService.deleteEmployer(employerId);
            return ResponseEntity.ok().build();
        }

    }

