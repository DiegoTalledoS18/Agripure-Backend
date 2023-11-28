package com.deviot.agripurebackend.crop.interfaces.rest;

import com.deviot.agripurebackend.crop.application.internal.CropCommandService;
import com.deviot.agripurebackend.crop.application.internal.QueryService.CropQueryService;
import com.deviot.agripurebackend.crop.domain.model.entities.Crop;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.SetSpecialistToCropCommand;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropByIdQuery;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/crops")
public class CropController {
    private final CropCommandService cropCommandService;
    private final CropQueryService cropQueryService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createCrop(@RequestBody CreateCropCommand createCropCommand){
        this.cropCommandService.handle(createCropCommand);
        return ResponseEntity.ok("Crop created!!!");
    }
    @CrossOrigin
    @GetMapping("/{farmerId}")
    public ResponseEntity<?> getCropsByFarmerId(@PathVariable("farmerId") Long farmerId){

        GetCropsByFarmerIdQuery getCropsByFarmerIdQuery=new GetCropsByFarmerIdQuery(farmerId);
        List<Crop> crops=this.cropQueryService.handle(getCropsByFarmerIdQuery);
        return ResponseEntity.ok(crops);
    }
    @CrossOrigin
    @GetMapping("/getCrop/{cropId}")
    public ResponseEntity<?> getCropById(@PathVariable("cropId") Long cropId){
        GetCropByIdQuery getCropByIdQuery=new GetCropByIdQuery(cropId);
        Crop crop= this.cropQueryService.handle(getCropByIdQuery);
        if(crop!=null){
            return ResponseEntity.ok(crop);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping("/setSpecialistToProject")
    public ResponseEntity<?> setSpecialistToProject(@RequestBody SetSpecialistToCropCommand setSpecialistToCropCommand){
        String message=this.cropCommandService.handle(setSpecialistToCropCommand);
        return ResponseEntity.ok(message);
    }

    @CrossOrigin
    @DeleteMapping("/deleteCrop/{cropId}")
    public ResponseEntity<?> deleteCropById(@PathVariable("cropId") Long cropId){
        DeleteCropCommand deleteCropCommand=new DeleteCropCommand(cropId);
        String message=this.cropCommandService.handle(deleteCropCommand);
        return ResponseEntity.ok(message);
    }
}
