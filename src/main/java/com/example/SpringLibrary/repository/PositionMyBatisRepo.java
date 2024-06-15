package com.example.SpringLibrary.repository;

import com.example.SpringLibrary.model.entity.Position;
import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PositionMyBatisRepo {
    List<ConnectPos> findAll();
    ConnectPos findByPositionID(@Param("positionId") Long positionId);
    void insert(Position position);
    void update(Position position);
    void delete(@Param("positionId") Long positionId);

}
