package ru.runanddone.admin.contragents.model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContragentMapper {

    private final ModelMapper mapper;

    @Autowired
    public ContragentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public Contragent toEntity(ContragentDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Contragent.class);
    }

    public ContragentDto toDto(Contragent entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ContragentDto.class);
    }
}
