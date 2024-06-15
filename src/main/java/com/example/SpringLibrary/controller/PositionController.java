package com.example.SpringLibrary.controller;


import com.example.SpringLibrary.model.dto.request.PositionRequest;
import com.example.SpringLibrary.model.dto.response.PositionResponse;
import com.example.SpringLibrary.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<List<PositionResponse>> getAllPositions() {
        List<PositionResponse> positions = positionService.getAllPositions();
        return ResponseEntity.ok(positions);
    }

    @GetMapping("positionId/{positionId}")
    public ResponseEntity<PositionResponse> getPositionByID(@PathVariable("positionId") Long positionId ,
                                                            @PathVariable("departmentId")Long departmentId)
    {
        PositionResponse position  = positionService.getPositionByID(positionId);
        return ResponseEntity.ok(position);
    }

    @PostMapping
    public ResponseEntity<Void> addPosition(@RequestBody PositionRequest positionRequest ) {
        positionService.addPosition(positionRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/positionId/{positionId}")
    public ResponseEntity<Void> updatePosition(@PathVariable Long positionId,
                                                 @RequestBody PositionRequest positionRequest ) {
        positionService.updatePosition(positionId, positionRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/positionId/{positionId}")
    public ResponseEntity<Void> deletePositionByID(@PathVariable Long positionId){
        positionService.deletePosition(positionId);
        return ResponseEntity.ok().build();
    }

}
