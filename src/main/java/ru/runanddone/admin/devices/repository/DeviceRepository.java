package ru.runanddone.admin.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.devices.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}
