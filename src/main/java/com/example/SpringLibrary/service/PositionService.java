package com.example.SpringLibrary.service;


import com.example.SpringLibrary.model.dto.request.PositionRequest;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.model.entity.wrapper.ConnectWrapper;

import java.util.List;

public interface PositionService {

    List <PositionResponse> getAllPositions ();
    PositionResponse getPositionByID(Long positionId);
    void addPosition(PositionRequest positionRequest);
    void updatePosition(Long positionId, PositionRequest positionRequest);
    void deletePosition(Long positionId);
}
