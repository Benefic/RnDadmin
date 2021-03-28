package ru.runanddone.admin.devices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.employees.model.Employee;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rd_dev_statistics")
public class DeviceStatisticRecord {

    @EmbeddedId
    private DeviceStatisticRecordKey key;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Integer battery;
    private String latitude;
    private String longitude;
    private Double memory;
    private String ver;
    private String device;
    private boolean sent;

}
