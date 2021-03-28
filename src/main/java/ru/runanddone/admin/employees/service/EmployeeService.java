package ru.runanddone.admin.employees.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.employees.model.EmployeeDto;
import ru.runanddone.admin.employees.model.EmployeeMapper;
import ru.runanddone.admin.employees.repository.EmployeeRepository;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public Page<EmployeeDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
