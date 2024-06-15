package com.example.SpringLibrary.repository;

import com.example.SpringLibrary.model.entity.Employer;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EmployerMyBatisRepo {

        List<ConnectWrapper> findAll();
        ConnectWrapper findByEmployerID(@Param("employerId") Long employerId);
        void insert(Employer employer );
        void update(Employer employer);
        void delete(@Param("employerId") Long employerId);

    }

