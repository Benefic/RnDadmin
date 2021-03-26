package ru.runanddone.admin.employees.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeTypeDto {
    private byte id;
    private String name;
}
