package ru.runanddone.admin.contragents.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.items.model.ItemDto;
import ru.runanddone.admin.orders.model.OrderTypeDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ContragentOrdertypeDto {
    private ContragentDto contragent;
    private OrderTypeDto orderType;
    private byte sort;
    private double paymentPercent;
    private double paymentMin;
    private double assemblyPercent;
    private double assemblyMin;
    private double claimRate;
    private double giftsRate;
    private LocalDateTime uptime;
    private ItemDto item;
}
