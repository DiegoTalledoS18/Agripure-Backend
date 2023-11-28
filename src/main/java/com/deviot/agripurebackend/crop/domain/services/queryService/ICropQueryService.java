package com.deviot.agripurebackend.crop.domain.services.queryService;

import com.deviot.agripurebackend.crop.domain.model.entities.Crop;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropByIdQuery;
import com.deviot.agripurebackend.crop.domain.model.queries.GetCropsByFarmerIdQuery;

import java.util.List;

public interface ICropQueryService {
    Crop handle(GetCropByIdQuery getCropByIdQuery);
    List<Crop> handle(GetCropsByFarmerIdQuery getCropsByFarmerIdQuery);
}
