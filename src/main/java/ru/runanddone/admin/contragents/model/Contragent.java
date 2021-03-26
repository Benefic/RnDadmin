package ru.runanddone.admin.contragents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ru.runanddone.admin.cityes.model.City;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_contragents")
public class Contragent {

    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String phone_serv;
    private LocalDateTime uptime;

    @Column(name = "isgroup")
    private boolean isGroup;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Contragent parrent;

    @Lob
    @Column(name = "logotype", columnDefinition = "mediumblob")
    private byte[] logotype;


}
