package ru.runanddone.admin.contragents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.contragents.model.ContragentMapper;
import ru.runanddone.admin.contragents.repository.ContragentRepository;
import ru.runanddone.admin.contragents.repository.ContrgentDataMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class ContragentService {

    private final ContragentRepository repository;
    private final ContragentMapper mapper;
    private final ContrgentDataMapper contrgentDataMapper = new ContrgentDataMapper();

    public List<ContragentDto> getAll(int page, int size) {
        return contrgentDataMapper.getAll();
        //return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
