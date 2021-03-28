package ru.runanddone.admin.devices.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Embeddable
public class DeviceStatisticRecordKey implements Serializable {
    protected LocalDateTime time;
    protected String dev_id;
}
