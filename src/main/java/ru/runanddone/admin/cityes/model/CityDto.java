package ru.runanddone.admin.cityes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityDto {
    private String id;

    private String code;
    private String name;

    private Byte officeId;
}
