package com.deviot.agripurebackend.crop.domain.services;

import com.deviot.agripurebackend.crop.domain.model.commands.*;

public interface ICropCommandService {
    String handle(CreateCropCommand createCropCommand);

    String handle(SetSpecialistToCropCommand setSpecialistToCropCommand);
    String handle(DeleteCropCommand deleteCropCommand);



}
