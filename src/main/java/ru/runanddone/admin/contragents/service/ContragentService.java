package ru.runanddone.admin.contragents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.contragents.model.ContragentMapper;
import ru.runanddone.admin.contragents.repository.ContragentRepository;

@Service
public class ContragentService {

    private final ContragentRepository repository;
    private final ContragentMapper mapper;

    @Autowired
    public ContragentService(ContragentRepository repository, ContragentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<ContragentDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
