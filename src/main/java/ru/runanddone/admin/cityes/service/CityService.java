package ru.runanddone.admin.cityes.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.cityes.model.CityMapper;
import ru.runanddone.admin.cityes.repository.CityRepository;

@AllArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;


    public Page<CityDto> getAll(int page, int size) {
        return cityRepository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(cityMapper::toDto);
    }

    public CityDto getById(String id) {
        return cityMapper.toDto(cityRepository.getById(id));
    }

    public CityDto add(CityDto cityDto) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(cityDto)));
    }

    public void delete(String id) {
        cityRepository.deleteById(id);
    }

}
