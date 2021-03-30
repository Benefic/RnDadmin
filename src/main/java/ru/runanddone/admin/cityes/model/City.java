package ru.runanddone.admin.cityes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_cities")
public class City {
    @Id
    @GenericGenerator(name = "UUID_office_id", strategy = "ru.runanddone.admin.cityes.repository.CityIdGenerator")
    @GeneratedValue(generator = "UUID_office_id")
    private String id;

    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id")
    private Office office;
}
