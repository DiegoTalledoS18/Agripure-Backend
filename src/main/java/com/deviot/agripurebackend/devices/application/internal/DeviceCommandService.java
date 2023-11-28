package com.deviot.agripurebackend.devices.application.internal;

import com.deviot.agripurebackend.devices.domain.model.aggregate.Device;
import com.deviot.agripurebackend.devices.domain.model.commands.*;
import com.deviot.agripurebackend.devices.domain.service.CommandService.IDeviceCommandService;
import com.deviot.agripurebackend.devices.infrastructure.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceCommandService implements IDeviceCommandService {
    private final DeviceRepository deviceRepository;


    @Override
    public Long handle(updateDeviceByIdCommand updateDeviceByIdCommand) {
        Optional<Device> device=deviceRepository.findById(updateDeviceByIdCommand.id());
        if(device.isPresent()){
            device.get().setName(updateDeviceByIdCommand.name());
            device.get().setCropName(updateDeviceByIdCommand.cropName());
            device.get().setProjectId(updateDeviceByIdCommand.projectId());
            device.get().setActive(updateDeviceByIdCommand.active());
            device.get().setActiveNotification(updateDeviceByIdCommand.activeNotification());
            Device updatedDevice = deviceRepository.save(device.get());
            return updatedDevice.getId();
        }else {
            return (long)0;
        }
    }

    @Override
    public Long handle(createDeviceCommand command) {
        Device newDevice= Device.builder().name(command.name())
                .model(command.model())
                .category(command.category())
                .cropName(command.cropName())
                .cropId(command.cropId())
                .farmerId(command.farmerId())
                .projectId(command.projectId())
                .active(false)
                .activeNotification(false)
                .activeRealTimeData(false)
                .planTemperature(0.0)
                .planHumidity(0.0)
                .build();
        // Guardar el dispositivo y obtener el dispositivo guardado con el ID asignado
        Device savedDevice = deviceRepository.save(newDevice);

        // Obtener el ID del dispositivo guardado
        Long deviceId = savedDevice.getId();

        return deviceId;
    }

    @Override
    public String handle(setActiveNotification command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActiveNotification(command.newStatus());
            deviceRepository.save(device.get());
            return "Device status notification changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public String handle(setDeviceStatus command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActive(command.newStatus());
            device.get().setActiveNotification(command.newStatus());
            device.get().setActiveRealTimeData(command.newStatus());
            deviceRepository.save(device.get());
            return "Device status changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public String handle(SetRealTimeDataCommand command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActiveRealTimeData(command.newStatus());
            deviceRepository.save(device.get());
            return "Device status changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public Long handle(SetTemperatureCommand command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setPlanTemperature(command.temperature());
            device.get().setPlanHumidity(command.humidity());
            deviceRepository.save(device.get());
            return 1L;
        }
        else{
            return 0L;
        }

    }

    @Override
    public Long handle(AssignDeviceToCropCommand command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if (device.isPresent()){
            device.get().setCropId(command.cropId());
            deviceRepository.save(device.get());
            return 1L;
        }
        else{
            return 0L;
        }
    }
}
