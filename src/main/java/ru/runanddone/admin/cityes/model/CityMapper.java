package ru.runanddone.admin.cityes.model;

import org.mapstruct.Mapper;

@Mapper
public interface CityMapper {

    City toEntity(CityDto dto);

    CityDto toDto(City entity);
}
