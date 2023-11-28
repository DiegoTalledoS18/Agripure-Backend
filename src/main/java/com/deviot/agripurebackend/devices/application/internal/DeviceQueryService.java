package com.deviot.agripurebackend.devices.application.internal;

import com.deviot.agripurebackend.devices.domain.model.aggregate.Device;
import com.deviot.agripurebackend.devices.domain.model.queries.GetDeviceByIdQuery;

import com.deviot.agripurebackend.devices.domain.model.queries.GetTemperaturesAndHumidityByCropIdQuery;
import com.deviot.agripurebackend.devices.domain.model.queries.*;

import com.deviot.agripurebackend.devices.domain.model.queries.GetDevicesByFarmerIdQuery;

import com.deviot.agripurebackend.devices.domain.model.queries.getTemperatureQuery;
import com.deviot.agripurebackend.devices.domain.service.queryService.IDeviceQueryService;
import com.deviot.agripurebackend.devices.interfaces.DTOs.TemperatureAndHumidity;
import com.deviot.agripurebackend.devices.infrastructure.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceQueryService implements IDeviceQueryService {
    private final DeviceRepository deviceRepository;

    @Override
    public List<Device> handle(GetDevicesByCropIdQuery getDevicesByCropIdQuery) {
        List<Device> devices=deviceRepository.findDevicesByCropId(getDevicesByCropIdQuery.cropId());
        return devices;
    }

    @Override
    public Device handle(getTemperatureQuery query) {
        Optional<Device> device=deviceRepository.findById(query.deviceId());
        return device.get();
    }

    @Override
    public Device handle(GetDeviceByIdQuery query) {
        Optional<Device> device=deviceRepository.findById(query.deviceId());
        return device.get();
    }

    @Override

    public List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query) {
        List<Device> devices = deviceRepository.findDevicesByCropId(query.cropId());
        return devices.stream().map(device -> {
            TemperatureAndHumidity data = new TemperatureAndHumidity();
            data.setDeviceId(device.getId());
            data.setName(device.getName());
            data.setIsActiveRealTimeData(device.isActiveRealTimeData());
            data.setTemperature(device.getPlanTemperature());
            data.setHumidity(device.getPlanHumidity());
            return data;
        }).collect(Collectors.toList());
    }

    public List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery) {
        List<Device> devices=deviceRepository.findDevicesByFarmerId(getDevicesByFarmerIdQuery.farmerId());
        return devices;

    }
}
