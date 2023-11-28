package com.deviot.agripurebackend.kms.application;

import com.deviot.agripurebackend.kms.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.kms.domain.model.queries.GetPlantByIdQuery;
import com.deviot.agripurebackend.kms.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.deviot.agripurebackend.kms.domain.services.IPlantQueryService;
import com.deviot.agripurebackend.kms.infrastructure.PlantRepository;
import com.deviot.agripurebackend.kms.interfaces.resources.RangesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantQueryService implements IPlantQueryService {
    private final PlantRepository plantRepository;
    @Override
    public Plant handle(GetPlantByIdQuery getPlantByIdQuery) {
        Optional<Plant> plant=plantRepository.findById(getPlantByIdQuery.plantId());
        if(plant.isPresent()){
            return plant.get();
        }
        else{
            throw new RuntimeException("The plant with the given id doesn't exist");
        }
    }

    @Override
    public RangesDTO handle(GetTemperatureAndHumidityRangesByPlantIdQuery query) {
        Optional<Plant> plant=plantRepository.findById(query.plantId());
        if(plant.isPresent()){
            RangesDTO response= new RangesDTO();
            response.setMinTemperature(plant.get().getMinTemperature());
            response.setMaxTemperature(plant.get().getMaxTemperature());
            response.setMaxHumidity(plant.get().getMaxHumidity());
            response.setMinHumidity(plant.get().getMinHumidity());
            return response;
        }
        return null;
    }

    @Override
    public List<Plant> handle() {
        List<Plant> plants= plantRepository.findAll();
        return plants;
    }
}
