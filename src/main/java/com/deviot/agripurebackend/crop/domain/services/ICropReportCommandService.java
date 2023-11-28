package com.deviot.agripurebackend.crop.domain.services;

import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;

import java.io.IOException;

public interface ICropReportCommandService {
    String handle(AddCropReportCommand addCropReportCommand) throws IOException;
    String handle(DeleteCropReportCommand deleteCropReportCommand);
}
