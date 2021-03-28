package ru.runanddone.admin.devices.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class DeviceMapper {

    private final ModelMapper mapper;

    public Device toEntity(DeviceDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Device.class);
    }

    public DeviceDto toDto(Device entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceDto.class);
    }
}
