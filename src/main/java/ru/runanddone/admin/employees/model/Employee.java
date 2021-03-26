package ru.runanddone.admin.employees.model;

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
@Table(name = "rd_employees")
public class Employee {
    @Id
    private String id;

    private String code;

    @Column(name = "isgroup")
    private boolean isGroup;

    private String name;
    private String address;
    private String phone;
    private String email;
    private String passphrase;
    private int pin;
    private boolean dismissed;
    private LocalDateTime uptime;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Employee parent;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private EmployeeType type;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;

    @ManyToOne
    @JoinColumn(name = "contragent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Contragent contragent;
}
