package ru.runanddone.admin.items.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.offices.model.OfficeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ItemDto {

    private String id;
    private String code;
    private boolean isGroup;
    private String article;
    private String name;
    private String description;
    private String packUnit;
    private double price;
    private double priceMin;
    private double priceAdd;
    private byte priceMethod;
    private double time;
    private boolean activity;
    private LocalDateTime uptime;

    // TODO add type_id
    private ContragentDto contragent;
    private CityDto city;
    private OfficeDto office;
    private ItemDto parent;
}
