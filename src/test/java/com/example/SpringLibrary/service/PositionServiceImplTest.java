package com.example.SpringLibrary.service;

import com.example.SpringLibrary.mapper.PositionMapper;
import com.example.SpringLibrary.model.dto.request.PositionRequest;
import com.example.SpringLibrary.model.dto.response.DepartmentsResponse;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.Position;
import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
import com.example.SpringLibrary.repository.PositionMyBatisRepo;
import com.example.SpringLibrary.service.impl.PositionImplService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class PositionServiceImplTest {
    @Mock
    private PositionMyBatisRepo positionMyBatisRepo;

    @InjectMocks
    private PositionImplService positionImplService;
    @Mock
    private PositionMapper positionMapper;

    @Test
    void getAllPosition_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        ConnectPos tests = ConnectPos
                .builder()
                .positionId(1L)
                .positionName("Web-Design")
                .salary(20000)
                .build();
        List<ConnectPos> connectPosList = List.of(tests);

        PositionResponse positionResponse =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Web-Design")
                        .salary(18000)
                        .departments(new DepartmentsResponse())
                        .build();
        List<PositionResponse> excepted = List.of(positionResponse);
        //when
        when(positionMyBatisRepo.findAll()).thenReturn(connectPosList);
        when(positionMapper.toPositionList(connectPosList)).thenReturn(excepted);

        //then
        List<PositionResponse> actual = positionImplService.getAllPositions();
        assertEquals(excepted, actual);
        verify(positionMyBatisRepo, times(1)).findAll();
        verify(positionMapper, times(1)).toPositionList(connectPosList);
        verifyNoMoreInteractions(positionMapper, positionMyBatisRepo);
    }


@Test
    void getPositionById_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2022-03-08 12:29:50", formatter);
        ConnectPos tests = ConnectPos
                .builder()
                .positionId(1L)
                .positionName("Web-Design")
                .salary(20000)
                .build();
        List<ConnectPos> connectPosList = List.of(tests);

        PositionResponse positionResponse =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Proqramist")
                        .salary(20000)
                        .departments(new DepartmentsResponse())
                        .build();
        List<PositionResponse> excepted = List.of(positionResponse);
        //when
        when(positionMyBatisRepo.findByPositionID(positionResponse.getPositionId())).thenReturn(tests);
        when(positionMapper.toPositionResponse(tests)).thenReturn(positionResponse);

        //then
        PositionResponse actual = positionImplService.getPositionByID(positionResponse.getPositionId());
        assertEquals(excepted, actual);
        verify(positionMyBatisRepo, times(1)).findByPositionID(positionResponse.getPositionId());
        verify(positionMapper, times(1)).toPositionResponse(tests);
        verifyNoMoreInteractions(positionMapper, positionMyBatisRepo);
    }
@Test
    void getInsertPos_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Position test= Position
                .builder()
                .positionId(1L)
                .salary(20000)
                .positionName("Web")
                .departmentId(1L)
                .build();
        PositionRequest positionRequest =
                PositionRequest
                        .builder()
                        .positionName("Web-Design")
                        .salary(20000)
                        .departmentId(1L)
                        .build();
        //when
        doNothing().when(positionMyBatisRepo).insert(test);
        when(positionMapper.toPosition(positionRequest)).thenReturn(test);

        //then
        positionImplService.addPosition(positionRequest);

        verify(positionMyBatisRepo,times(1)).insert(test);
        verify(positionMapper,times(1)).toPosition(positionRequest);
        verifyNoMoreInteractions(positionMapper,positionMyBatisRepo);
    }
@Test
    void getUpdatePosition_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Position test= Position
                .builder()
                .positionId(1L)
                .salary(20000)
                .positionName("Web")
                .departmentId(1L)
                .build();
        PositionRequest positionRequest =
                PositionRequest
                        .builder()
                        .positionName("Web-Design")
                        .salary(20000)
                        .build();
        //when
        doNothing().when(positionMyBatisRepo).update(test);
        when(positionMapper.toPositionById(test.getPositionId(),positionRequest)).thenReturn(test);

        //then
        positionImplService.updatePosition(test.getPositionId(),positionRequest);

        verify(positionMyBatisRepo,times(1)).update(test);
        verify(positionMapper,times(1)).toPositionById(test.getPositionId(),positionRequest);
        verifyNoMoreInteractions(positionMapper,positionMyBatisRepo);
    }

    @Test
    void get_deletePositionSuccess(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2022-03-08 12:29:50", formatter);
        Position test= Position
                .builder()
                .positionId(1L)
                .salary(18000)
                .positionName("Web_Design")
                .departmentId(1L)
                .build();
        //when
        doNothing().when(positionMyBatisRepo).delete(test.getPositionId());
        //then
        positionImplService.deletePosition(test.getPositionId());

        verify(positionMyBatisRepo,times(1)).delete(test.getPositionId());
        verifyNoMoreInteractions(positionMapper,positionMyBatisRepo);
    }
}
