package ru.runanddone.admin.devices.model;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.runanddone.admin.devices.repository.DeviceRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@AllArgsConstructor
@Component
public class DeviceStatisticMapper {

    private final ModelMapper mapper;
    private final DeviceRepository deviceRepository;

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(DeviceStatisticRecord.class, DeviceStatisticRecordDto.class)
                .addMappings(m -> m.skip(DeviceStatisticRecordDto::setDev))
                .setPostConverter(toDtoConverter());
    }

    private Converter<DeviceStatisticRecord, DeviceStatisticRecordDto> toDtoConverter() {
        return context -> {
            DeviceStatisticRecord source = context.getSource();
            DeviceStatisticRecordDto destination = context.getDestination();
            mapDevice(source, destination);
            return context.getDestination();
        };
    }

    private void mapDevice(DeviceStatisticRecord source, DeviceStatisticRecordDto destination) {
        if (source.getKey().dev_id != null) {
            Device device = deviceRepository.findById(source.getKey().dev_id).orElse(null);
            destination.setDev(mapper.map(device, DeviceDto.class));
            destination.setTime(source.getKey().getTime());
        }
    }

    public DeviceStatisticRecord toEntity(DeviceStatisticRecordDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, DeviceStatisticRecord.class);
    }

    public DeviceStatisticRecordDto toDto(DeviceStatisticRecord entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, DeviceStatisticRecordDto.class);
    }
}
