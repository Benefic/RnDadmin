package ru.runanddone.admin.log.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.log.model.ObjectLogDto;
import ru.runanddone.admin.log.repository.ObjectLogRepository;

@Service
@RequiredArgsConstructor
public class ObjectLogService {

    private final ObjectLogRepository repository;
    private final ModelMapper mapper;

    public Page<ObjectLogDto> getAll(Pageable params) {
        return repository.findAllWithPagination(params).map(it -> mapper.map(it, ObjectLogDto.class));
    }
}
