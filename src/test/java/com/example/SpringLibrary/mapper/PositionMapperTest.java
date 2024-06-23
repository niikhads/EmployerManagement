package com.example.SpringLibrary.mapper;

import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PositionMapperTest {
    @Autowired
    private PositionMapper positionMapper;

    @Test
    public void testPositionMapper() {
        ConnectPos connectPos = ConnectPos
                .builder()
                .positionId(1L)
                .positionName("Web-Design")
                .salary(900)
                .build();

        PositionResponse expected =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Web-Design")
                        .salary(1700)
                        .departments(new DepartmentsResponse())
                        .build();
        PositionResponse actual = positionMapper.toPositionResponse(connectPos);
        assertEquals(expected, actual);
    }
}