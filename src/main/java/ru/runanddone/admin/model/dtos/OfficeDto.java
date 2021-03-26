package ru.runanddone.admin.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OfficeDto {
    private byte id;
    private String code;
    private String name;
    private String prefix;
    private boolean controllocation;
    private int controllocationdistance;
    private boolean push_active;
}
