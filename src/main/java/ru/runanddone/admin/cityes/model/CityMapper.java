package ru.runanddone.admin.cityes.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class CityMapper {

    private final ModelMapper mapper;

/*    @PostConstruct
    public void setupMapper(){
        mapper.createTypeMap(City.class, CityDto.class)
                .addMappings( m -> m.skip(CityDto::setOffice))
                .setPostConverter(toDtoConverter());
    }

    public Converter<City, CityDto> toDtoConverter(){
        return context -> {

        }
    }*/


    public City toEntity(CityDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, City.class);
    }

    public CityDto toDto(City city) {
        return Objects.isNull(city) ? null : mapper.map(city, CityDto.class);
    }
}
