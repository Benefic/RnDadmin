package ru.runanddone.admin.cityes.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.offices.model.OfficeDto;

@Data
@NoArgsConstructor
public class CityDto {
    private String id;

    private String code;
    private String name;

    private OfficeDto office;
}
