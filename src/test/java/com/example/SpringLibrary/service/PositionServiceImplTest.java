//package com.example.SpringLibrary.service;
//
//import com.example.SpringLibrary.mapper.EmployerMapper;
//import com.example.SpringLibrary.mapper.PositionMapper;
//import com.example.SpringLibrary.model.dto.response.EmployerResponse;
//import com.example.SpringLibrary.model.dto.response.PositionResponse;
//import com.example.SpringLibrary.model.entity.Employer;
//import com.example.SpringLibrary.model.entity.Position;
//import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
//import com.example.SpringLibrary.repository.EmployerMyBatisRepo;
//import com.example.SpringLibrary.repository.PositionMyBatisRepo;
//import com.example.SpringLibrary.service.impl.EmployerImplService;
//import com.example.SpringLibrary.service.impl.PositionImplService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//
//
//@ExtendWith(MockitoExtension.class)
//public class PositionServiceImplTest {
//    @Mock
//    private PositionMyBatisRepo positionMyBatisRepo;
//    @Mock
//    private PositionMapper positionMapper;
//
//    @InjectMocks
//    private PositionImplService positionService;
//
//
//    @Test
//    void getAllPosition_SuccessTest() {
//
//        //given
//        Position position = Position.builder()
//                .positionId(1L)
//                .positionName("Management")
//                .salary(45000)
//                .build();
//
//        List<Position> connectPosList = List.of(position);
//
//        PositionResponse positionResponse = PositionResponse.builder()
//                .positionId(1L)
//                .positionName("Management")
//                .salary(45000)
//                .build();
//        List<PositionResponse> expected = List.of(positionResponse);
//
//
//        //when
//        when(positionMyBatisRepo.findAll()).thenReturn(connectPosList);
//        when(positionMapper.toPositionList(connectPosList)).thenReturn(expected);
//
//
//        //then
//        List<PositionResponse> actual = positionService.getAllPositions();
//
//
//        assertEquals(expected, actual);
//
//        verify(positionMyBatisRepo,times(2)).findAll();
//        verify(positionMapper,times(1)).toPositionResponse(connectPosList);
//        verifyNoMoreInteractions(positionMyBatisRepo,positionMapper);
//     //   verifyNoInteractions(positionMyBatisRepo);
//    }
//}
