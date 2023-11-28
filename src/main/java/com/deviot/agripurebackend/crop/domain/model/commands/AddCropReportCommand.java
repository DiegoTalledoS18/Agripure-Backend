package com.deviot.agripurebackend.crop.domain.model.commands;


public record AddCropReportCommand(Long cropId, String description, String image) {
}
