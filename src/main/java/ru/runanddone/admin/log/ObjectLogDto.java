package ru.runanddone.admin.log;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.runanddone.admin.offices.model.OfficeDto;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ObjectLogDto {

    private Long id;
    private String ObjId;
    private Instant time;
    private OfficeDto office;
    private Integer userId;
    private String devId;
    private String ipAddress;
    private String typeId;
    private String tableName;
    private String data;
    private String request;

}
