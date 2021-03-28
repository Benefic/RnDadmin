package ru.runanddone.admin.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.employees.model.EmployeeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DeviceStatisticRecordDto {

    private DeviceDto dev;
    private LocalDateTime time;

    private EmployeeDto employee;
    private Integer battery;
    private String latitude;
    private String longitude;
    private Double memory;
    private String ver;
    private String device;
    private boolean sent;

}
