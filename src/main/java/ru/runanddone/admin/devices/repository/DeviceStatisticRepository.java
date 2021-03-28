package ru.runanddone.admin.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.devices.model.DeviceStatisticRecord;
import ru.runanddone.admin.devices.model.DeviceStatisticRecordKey;

@Repository
public interface DeviceStatisticRepository extends JpaRepository<DeviceStatisticRecord, DeviceStatisticRecordKey> {
}
