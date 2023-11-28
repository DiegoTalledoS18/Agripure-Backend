package com.deviot.agripurebackend.devices.infrastructure;

import com.deviot.agripurebackend.devices.domain.model.aggregate.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Long> {

    List<Device> findDevicesByCropId(Long cropId);

    List<Device> findDevicesByFarmerId(Long farmerId);

}
