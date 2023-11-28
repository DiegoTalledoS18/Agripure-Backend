package com.deviot.agripurebackend.devices.domain.model.commands;

public record setDeviceStatus(Long deviceId,boolean newStatus) {
}
