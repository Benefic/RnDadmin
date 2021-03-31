package ru.runanddone.admin.cityes.model;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.runanddone.admin.common.ObjectNotFoundException;
import ru.runanddone.admin.offices.model.Office;
import ru.runanddone.admin.offices.repository.OfficeRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@AllArgsConstructor
@Component
public class CityMapper {

    private final ModelMapper mapper;
    private final OfficeRepository officeRepository;

    @PostConstruct
    public void setupMapper() {

        mapper.createTypeMap(CityDto.class, City.class)
                .addMappings(m -> m.skip(City::setOffice))
                .setPostConverter(toEntityConverter());

        mapper.createTypeMap(City.class, CityDto.class)
                .addMappings(m -> m.skip(CityDto::setOfficeId))
                .addMappings(m -> m.skip(CityDto::setOfficeName))
                .setPostConverter(toDtoConverter());
    }

    public Converter<City, CityDto> toDtoConverter() {
        return context -> {
            City source = context.getSource();
            CityDto destination = context.getDestination();
            Office office = source.getOffice();
            destination.setOfficeId(office.getId());
            destination.setOfficeName(office.getName());
            return context.getDestination();
        };
    }

    public Converter<CityDto, City> toEntityConverter() {
        return context -> {
            CityDto source = context.getSource();
            City destination = context.getDestination();
            destination.setOffice(officeRepository.findById(source.getOfficeId())
                    .orElseThrow(() -> new ObjectNotFoundException("Office with ID " + source.getOfficeId() + " not exist")));
            return context.getDestination();
        };
    }


    public City toEntity(CityDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, City.class);
    }

    public CityDto toDto(City city) {
        return Objects.isNull(city) ? null : mapper.map(city, CityDto.class);
    }
}
