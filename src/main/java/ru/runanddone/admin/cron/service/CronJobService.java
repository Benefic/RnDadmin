package ru.runanddone.admin.cron.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.cron.model.CronJobDto;
import ru.runanddone.admin.cron.model.CronJobMapper;
import ru.runanddone.admin.cron.repository.CronJobRepository;

@AllArgsConstructor
@Service
public class CronJobService {
    private final CronJobRepository repository;
    private final CronJobMapper mapper;

    public Page<CronJobDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
