package com.example.SpringLibrary.repository;

import com.example.SpringLibrary.model.entity.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
@Mapper
public interface DepartmentsMyBatisRepo {
    List<Departments> findAll();
    Optional<Departments> findByDepartmentId(@Param("departmentId") Long departmentId);
    void insert(Departments departments);
    void update(Departments departments);
    void delete(@Param("departmentId") Long departmentId);

}
