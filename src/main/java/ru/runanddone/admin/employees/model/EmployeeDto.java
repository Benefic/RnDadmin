package ru.runanddone.admin.employees.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.cityes.model.City;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.offices.model.OfficeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    private String code;
    private boolean isGroup;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String passphrase;
    private int pin;
    private boolean dismissed;
    private LocalDateTime uptime;
    private EmployeeDto parent;
    private OfficeDto office;
    private EmployeeTypeDto type;
    private City city;
    private ContragentDto contragent;
}
