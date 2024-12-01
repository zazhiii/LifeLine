package com.zazhi.controller;

import com.zazhi.pojo.dto.NearbyFloodDTO;
import com.zazhi.pojo.entity.Flood;
import com.zazhi.pojo.result.Result;
import com.zazhi.service.FloodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/floor")
@Tag(name = "洪水")
public class FloodController {

    private static final Logger log = LoggerFactory.getLogger(FloodController.class);

    @Autowired
    private FloodService floorService;

    @PostMapping
    @Operation(summary = "获取附近洪水信息")
    public Result<List<Flood>> getNearbyFloors(@RequestBody NearbyFloodDTO nearByFloodDTO) {
        log.info("getNearbyFloors: {}", nearByFloodDTO);
        return Result.success(floorService.findNearbyFloors(nearByFloodDTO));
    }
}
