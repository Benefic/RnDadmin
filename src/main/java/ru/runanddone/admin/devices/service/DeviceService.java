package ru.runanddone.admin.devices.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.devices.model.DeviceDto;
import ru.runanddone.admin.devices.model.DeviceMapper;
import ru.runanddone.admin.devices.repository.DeviceRepository;

@AllArgsConstructor
@Service
public class DeviceService {
    private final DeviceRepository repository;
    private final DeviceMapper mapper;

    public Page<DeviceDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("time").descending())).map(mapper::toDto);
    }
}
