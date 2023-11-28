package com.deviot.agripurebackend.crop.application.internal.QueryService;

import com.deviot.agripurebackend.crop.domain.model.entities.Crop;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropByIdQuery;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;
import com.deviot.agripurebackend.crop.domain.services.queryService.ICropQueryService;
import com.deviot.agripurebackend.crop.infrastructure.CropRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropQueryService implements ICropQueryService {

    private final CropRepository cropRepository;
    @Override
    public Crop handle(GetCropByIdQuery getCropByIdQuery) {
        Optional<Crop> crop= cropRepository.findById(getCropByIdQuery.cropId());
        if(crop.isPresent()){
            return crop.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Crop> handle(GetCropsByFarmerIdQuery getCropsByFarmerIdQuery) {
        List<Crop>crops=cropRepository.findCropByFarmerId(getCropsByFarmerIdQuery.farmerId());
        return crops;
    }
}
