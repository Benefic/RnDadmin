package ru.runanddone.admin.contragents.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.contragents.model.ContragentMapper;
import ru.runanddone.admin.contragents.repository.ContragentRepository;

@AllArgsConstructor
@Service
public class ContragentService {

    private final ContragentRepository repository;
    private final ContragentMapper mapper;

    public Page<ContragentDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
