package com.deviot.agripurebackend.kms.domain.model.commands;

public record CreatePlantCommand(String name,String scientificName,String imageUrl,String variety,String landType,String weatherConditions,
                                 String distanceBetWeenPlants,String idealPlantingDepth,String fertilizationAndFumigation,
                                    Double pH
                                    ,Double minTemperature,Double maxTemperature,Double minHumidity,Double maxHumidity) {

}
