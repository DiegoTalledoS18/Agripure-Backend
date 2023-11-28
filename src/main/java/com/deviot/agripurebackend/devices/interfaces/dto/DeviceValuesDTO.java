package com.deviot.agripurebackend.devices.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceValuesDTO {
    double planTemperature;
    double planHumidity;
}
