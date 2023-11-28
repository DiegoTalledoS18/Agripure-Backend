package com.deviot.agripurebackend.devices.domain.model.commands;

public record SetTemperatureCommand(Long deviceId,Double temperature,Double humidity) {
}
