package ru.runanddone.admin.orders.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderTypeDto {
    private byte id;
    private String name;
}
