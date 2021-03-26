package ru.runanddone.admin.contragents.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.offices.model.OfficeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ContragentDto {

    private String id;
    private String code;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String phone_serv;
    private LocalDateTime uptime;
    private boolean isGroup;
    private CityDto city;
    private OfficeDto office;
    private ContragentDto parrent;
    private byte[] logotype;
}
