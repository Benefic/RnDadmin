package ru.runanddone.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.model.dtos.CityDto;
import ru.runanddone.admin.model.mappers.CityMapper;
import ru.runanddone.admin.repository.CityRepository;

@Service
public class CityService {
    private final CityRepository cityRepository;

    private final CityMapper cityMapper;

    @Autowired
    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public Page<CityDto> getAll(int page, int size) {
        return cityRepository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(cityMapper::toDto);
    }

    public boolean add(CityDto cityDto) {
        return false;
    }

}
