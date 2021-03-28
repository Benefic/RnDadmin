package ru.runanddone.admin.contragents.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.contragents.model.ContragentOrdertypeDto;
import ru.runanddone.admin.contragents.model.ContragentOrdertypeMapper;
import ru.runanddone.admin.contragents.repository.ContragentOrdertypeRepository;

@AllArgsConstructor
@Service
public class ContragentOrdertypeService {

    private final ContragentOrdertypeRepository repository;
    private final ContragentOrdertypeMapper mapper;

    public Page<ContragentOrdertypeDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("sort"))).map(mapper::toDto);
    }
}
