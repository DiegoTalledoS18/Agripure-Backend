package com.deviot.agripurebackend.devices.interfaces.DTOs;

import lombok.Data;

@Data
public class TemperatureAndHumidity {
    private Long deviceId;
    private String name;
    private Boolean isActiveRealTimeData;
    private Double temperature;
    private Double humidity;
}
