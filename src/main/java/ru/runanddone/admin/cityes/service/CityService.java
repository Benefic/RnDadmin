package ru.runanddone.admin.cityes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.cityes.model.CityMapper;
import ru.runanddone.admin.cityes.repository.CityDataMapper;
import ru.runanddone.admin.cityes.repository.CityRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    private final CityDataMapper cityDataMapper = new CityDataMapper();

    public List<CityDto> getAll(int page, int size) {
        return cityDataMapper.getAll();
        //return cityRepository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(cityMapper::toDto);
    }

    public CityDto getById(String id) {
        return cityDataMapper.getById(id);
    }

    public CityDto add(CityDto cityDto) {
        cityDataMapper.save(cityDto);
        return cityDto;
        //return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(cityDto)));
    }

}
