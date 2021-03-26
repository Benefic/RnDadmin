package ru.runanddone.admin.employees.model;

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
@Table(name = "rd_employeetypes")
public class EmployeeType {
    @Id
    private byte id;
    private String name;
}
