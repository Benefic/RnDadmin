package ru.runanddone.admin.items.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ru.runanddone.admin.cityes.model.City;
import ru.runanddone.admin.contragents.model.Contragent;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_items")
public class Item {
    @Id
    private String id;
    private String code;
    @Column(name = "isgroup")
    private boolean isGroup;
    private String article;
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String packUnit;
    private double price;
    private double priceMin;
    private double priceAdd;
    @Column(columnDefinition = "BIT")
    private byte priceMethod;
    private double time;
    private boolean activity;
    private LocalDateTime uptime;


    // TODO add type_id

    @ManyToOne
    @JoinColumn(name = "contragent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Contragent contragent;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Item parent;
}
