package ru.runanddone.admin.devices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.devices.model.DeviceStatisticMapper;
import ru.runanddone.admin.devices.model.DeviceStatisticRecordDto;
import ru.runanddone.admin.devices.repository.DeviceStatisticRepository;

@Service
public class DeviceStatisticService {
    private final DeviceStatisticRepository repository;
    private final DeviceStatisticMapper mapper;

    @Autowired
    public DeviceStatisticService(DeviceStatisticRepository repository, DeviceStatisticMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<DeviceStatisticRecordDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(mapper::toDto);
    }
}
