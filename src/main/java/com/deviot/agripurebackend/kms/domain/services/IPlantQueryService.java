package com.deviot.agripurebackend.kms.domain.services;

import com.deviot.agripurebackend.kms.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.kms.domain.model.queries.GetPlantByIdQuery;
import com.deviot.agripurebackend.kms.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.deviot.agripurebackend.kms.interfaces.resources.RangesDTO;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);
    RangesDTO handle(GetTemperatureAndHumidityRangesByPlantIdQuery query);
    List<Plant>handle();
}
