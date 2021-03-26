package ru.runanddone.admin.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_offices")
public class Office {
    @Id
    private byte id;
    private String code;
    private String name;
    private String prefix;
    private boolean controllocation;
    private int controllocationdistance;
    private boolean push_active;
}
