package ru.runanddone.admin.contragents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.items.model.Item;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_contragent_ordertype")
public class ContragentOrdertype {
    @EmbeddedId
    private ContragentOrdertypeKey key;
    private byte sort;

    @Column(name = "payment_percent")
    private double paymentPercent;
    @Column(name = "payment_min")
    private double paymentMin;
    @Column(name = "assembly_percent")
    private double assemblyPercent;
    @Column(name = "assembly_min")
    private double assemblyMin;
    @Column(name = "claim_rate")
    private double claimRate;
    @Column(name = "gifts_rate")
    private double giftsRate;
    private LocalDateTime uptime;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
