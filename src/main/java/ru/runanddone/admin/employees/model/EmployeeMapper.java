package ru.runanddone.admin.employees.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class EmployeeMapper {

    private final ModelMapper mapper;

    public Employee toEntity(EmployeeDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Employee.class);
    }

    public EmployeeDto toDto(Employee entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, EmployeeDto.class);
    }
}
