package com.deviot.agripurebackend.kms.domain.services;

import com.deviot.agripurebackend.kms.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.kms.domain.model.commands.DeletePlantCommand;
import com.deviot.agripurebackend.kms.domain.model.commands.GenerateSeedCommand;

public interface IPlantCommandService {
    String handle(GenerateSeedCommand generateSeedCommand);
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
