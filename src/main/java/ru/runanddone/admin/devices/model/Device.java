package ru.runanddone.admin.devices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.employees.model.Employee;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rd_devices")
public class Device {
    @Id
    private String id;

    @Column(name = "gcmtoken")
    private String gcmToken;
    private String os;
    private String device;
    private String request;
    private String code;
    private boolean active;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
