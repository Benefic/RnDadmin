package ru.runanddone.admin.employees.model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmployeeMapper {

    private final ModelMapper mapper;

    @Autowired
    public EmployeeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public Employee toEntity(EmployeeDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Employee.class);
    }

    public EmployeeDto toDto(Employee entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, EmployeeDto.class);
    }
}
