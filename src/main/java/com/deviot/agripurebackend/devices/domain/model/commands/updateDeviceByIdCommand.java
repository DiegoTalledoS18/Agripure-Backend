package com.deviot.agripurebackend.devices.domain.model.commands;

public record updateDeviceByIdCommand(Long id,String name, String cropName, Long projectId, Boolean active, Boolean activeNotification) {
}
