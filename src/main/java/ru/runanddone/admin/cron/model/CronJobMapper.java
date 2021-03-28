package ru.runanddone.admin.cron.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class CronJobMapper {

    private final ModelMapper mapper;

    public CronJob toEntity(CronJobDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, CronJob.class);
    }

    public CronJobDto toDto(CronJob entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CronJobDto.class);
    }
}
