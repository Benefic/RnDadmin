package ru.runanddone.admin.contragents.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class ContragentMapper {

    private final ModelMapper mapper;

    public Contragent toEntity(ContragentDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Contragent.class);
    }

    public ContragentDto toDto(Contragent entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ContragentDto.class);
    }
}
