package ru.runanddone.admin.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.employees.model.EmployeeDto;
import ru.runanddone.admin.offices.model.OfficeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DeviceDto {

    private String id;

    private String gcmToken;
    private String os;
    private String device;
    private String request;
    private String code;
    private boolean active;
    private LocalDateTime time;

    private OfficeDto office;
    private EmployeeDto employee;

}
