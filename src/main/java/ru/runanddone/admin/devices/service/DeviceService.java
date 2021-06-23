package ru.runanddone.admin.devices.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.devices.model.DeviceDto;
import ru.runanddone.admin.devices.model.DeviceMapper;
import ru.runanddone.admin.devices.repository.DeviceRepository;
import ru.runanddone.admin.devices.repository.DevicesDataMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class DeviceService {
    private final DeviceRepository repository;
    private final DeviceMapper mapper;

    private final DevicesDataMapper devicesDataMapper = new DevicesDataMapper();

    public List<DeviceDto> getAll(int page, int size) {
        return devicesDataMapper.getAll();
//        return repository.findAll(PageRequest.of(page, size, Sort.by("time").descending())).map(mapper::toDto);
    }
}
