package ru.runanddone.admin.model.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.runanddone.admin.model.dtos.CityDto;
import ru.runanddone.admin.model.entities.City;

import java.util.Objects;

@Component
public class CityMapper {

    private final ModelMapper mapper;

    @Autowired
    public CityMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public City toEntity(CityDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, City.class);
    }

    public CityDto toDto(City city) {
        return Objects.isNull(city) ? null : mapper.map(city, CityDto.class);
    }
}
