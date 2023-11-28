package com.deviot.agripurebackend.devices.domain.model.commands;

public record setActiveNotification(Long deviceId,boolean newStatus) {
}
