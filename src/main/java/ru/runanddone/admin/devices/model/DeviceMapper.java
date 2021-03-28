package ru.runanddone.admin.devices.model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DeviceMapper {

    private final ModelMapper mapper;

    @Autowired
    public DeviceMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public Device toEntity(DeviceDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Device.class);
    }

    public DeviceDto toDto(Device entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceDto.class);
    }
}
