package com.deviot.agripurebackend.kms.interfaces.rest;

import com.deviot.agripurebackend.kms.application.PlantCommandService;
import com.deviot.agripurebackend.kms.application.PlantQueryService;
import com.deviot.agripurebackend.kms.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.kms.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.kms.domain.model.commands.GenerateSeedCommand;
import com.deviot.agripurebackend.kms.domain.model.queries.GetPlantByIdQuery;
import com.deviot.agripurebackend.kms.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.deviot.agripurebackend.kms.interfaces.resources.RangesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/plant")
public class PlantController {
    private final PlantCommandService plantCommandService;
    private final PlantQueryService plantQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createPlant(@RequestBody CreatePlantCommand createPlantCommand){
        plantCommandService.handle(createPlantCommand);
        return ResponseEntity.ok("Plant created!!");
    }

    @CrossOrigin
    @PostMapping("/generateSeed")
    public ResponseEntity<?> generateSeed(){
        GenerateSeedCommand generateSeedCommand= new GenerateSeedCommand();
        String message= plantCommandService.handle(generateSeedCommand);
        return ResponseEntity.ok(message);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants(){
        List<Plant> plants=plantQueryService.handle();
        return ResponseEntity.ok(plants);
    }
    @CrossOrigin
    @GetMapping("/{plantId}")
    public ResponseEntity<Plant> getPLantById(@PathVariable("plantId") Long plantId){
        GetPlantByIdQuery getPlantByIdQuery=new GetPlantByIdQuery(plantId);
        Plant plant=plantQueryService.handle(getPlantByIdQuery);
        return ResponseEntity.ok(plant);
    }

    @CrossOrigin
    @GetMapping("/ranges/{plantId}")
    public ResponseEntity<RangesDTO> getRanges(@PathVariable("plantId")Long plantId){
        GetTemperatureAndHumidityRangesByPlantIdQuery query=new GetTemperatureAndHumidityRangesByPlantIdQuery(plantId);
        RangesDTO response=plantQueryService.handle(query);
        return ResponseEntity.ok(response);

    }
}
