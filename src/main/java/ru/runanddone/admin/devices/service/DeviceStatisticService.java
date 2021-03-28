package ru.runanddone.admin.devices.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.devices.model.DeviceStatisticMapper;
import ru.runanddone.admin.devices.model.DeviceStatisticRecordDto;
import ru.runanddone.admin.devices.repository.DeviceStatisticRepository;

@AllArgsConstructor
@Service
public class DeviceStatisticService {
    private final DeviceStatisticRepository repository;
    private final DeviceStatisticMapper mapper;

    public Page<DeviceStatisticRecordDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(mapper::toDto);
    }
}
