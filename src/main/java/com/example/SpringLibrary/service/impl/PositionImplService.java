package com.example.SpringLibrary.service.impl;

import com.example.SpringLibrary.mapper.PositionMapper;
import com.example.SpringLibrary.model.dto.request.PositionRequest;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.Position;
import com.example.SpringLibrary.model.entity.wrapper.ConnectPos;
import com.example.SpringLibrary.repository.PositionMyBatisRepo;
import com.example.SpringLibrary.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class PositionImplService implements PositionService {

    private final PositionMapper positionMapper  ;
    private final PositionMyBatisRepo positionMyBatisRepo ;


    @Override
    public List<PositionResponse> getAllPositions() {
        List<ConnectPos> wrapperList =positionMyBatisRepo.findAll();
        List<PositionResponse> positionList= positionMapper.toPositionList(wrapperList);
        return positionList;
    }

    @Override
    public PositionResponse getPositionByID(Long positionId) {
       ConnectPos connectPos = positionMyBatisRepo.findByPositionID(positionId);
        return positionMapper.toPositionResponse(connectPos);
    }

    @Override
    public void addPosition(PositionRequest positionRequest) {
        log.info("Insert received.PositionRequest:{}",positionRequest);
        Position position = positionMapper.toPosition(positionRequest);
        log.info("Mapper is successfully over. position:{}",position);
        positionMyBatisRepo.insert(position);
        log.info("Add process was succesfully.");
        log.warn("Warning!! Sorry your code doesn't work exactly right{}",positionRequest);
        log.error("Sorry, your code does not work properly, there is an error.{}",positionRequest);
    }

    @Override
    public void updatePosition(Long positionId, PositionRequest positionRequest) {
        Position position  = positionMapper.toPositionById(positionId, positionRequest);
        positionMyBatisRepo.update(position);
    }

    @Override
    public void deletePosition(Long positionId) {
         positionMyBatisRepo.delete(positionId);
    }

}
