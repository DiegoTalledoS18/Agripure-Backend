package com.deviot.agripurebackend.devices.domain.model.commands;

public record SetRealTimeDataCommand(Long deviceId,boolean newStatus) {
}
