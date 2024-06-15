package com.example.SpringLibrary.service.impl;

import com.example.SpringLibrary.mapper.EmployerMapper;
import com.example.SpringLibrary.model.dto.request.EmployerRequest;
import com.example.SpringLibrary.model.dto.response.EmployerResponse;
import com.example.SpringLibrary.model.entity.Employer;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import com.example.SpringLibrary.repository.EmployerMyBatisRepo;
import com.example.SpringLibrary.service.EmployerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
@RequiredArgsConstructor
@Slf4j

public class EmployerImplService implements EmployerService {

    private final EmployerMapper employerMapper ;
    private final EmployerMyBatisRepo employerMyBatisRepo;


    @Override
    public List<EmployerResponse> getAllEmployers() {
           List<ConnectWrapper> connectWrapperList = employerMyBatisRepo.findAll();
//           if(Objects.isNull(employers)  || isEmpty())
           List<EmployerResponse> employerResponseList = employerMapper.toEmployerResponseList(connectWrapperList);
           return employerResponseList;
    }

    @Override
    public EmployerResponse getEmployerByID(Long employerId) {
         ConnectWrapper connectWrapper =  employerMyBatisRepo.findByEmployerID(employerId);
          return   employerMapper.toEmployerResp(connectWrapper);

    }

    @Override
    public void addEmployer(EmployerRequest employerRequest) {
        log.info("The process is over.EmployerRequest:{}",employerRequest);
        Employer employer =employerMapper.toEmployer(employerRequest);
        log.info("Mapper is successfully over",employer);
        employerMyBatisRepo.insert(employer);
        log.info("Add process was successful.");
        log.warn("Just warning{}",employerRequest);
        log.error("Just error.{}",employerRequest);
    }

    @Override
    public void updateEmployer(Long employerId, EmployerRequest employerRequest) {
        Employer employer  = employerMapper.toEmployerById(employerId, employerRequest);
        employerMyBatisRepo.update(employer);
    }

    @Override
    public void deleteEmployer(Long employerId) {
            employerMyBatisRepo.delete(employerId);

    }
}