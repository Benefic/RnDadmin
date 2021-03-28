package ru.runanddone.admin.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
public class DeviceStatisticRecordKey implements Serializable {
    protected LocalDateTime time;
    protected String dev_id;
}
