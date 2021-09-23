package ru.runanddone.admin.cityes.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;

        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return 39525063;
    }
}
