package com.example.SpringLibrary.configure;

import com.example.SpringLibrary.mapper.DepartmentsMapper;
import com.example.SpringLibrary.mapper.EmployerMapper;
import com.example.SpringLibrary.mapper.PositionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigure {
    @Bean
    public EmployerMapper employerMapper(){
            return EmployerMapper.INSTANCE;
        }
    @Bean
    public DepartmentsMapper departmentsMapper(){
        return DepartmentsMapper.INSTANCE;
    }
    @Bean
    public PositionMapper positionMapper(){
        return PositionMapper.INSTANCE;
    }
    }

