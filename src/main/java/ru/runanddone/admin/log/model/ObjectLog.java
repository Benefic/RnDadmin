package ru.runanddone.admin.log.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ru.runanddone.admin.offices.model.Office;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "rd_obj_log", indexes = {
        @Index(name = "obj_id", columnList = "obj_id"),
        @Index(name = "time", columnList = "time")
})
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ObjectLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "obj_id", nullable = false, length = 40)
    private String ObjId;

    @Column(name = "time", nullable = false)
    private Instant time;

    @ManyToOne
    @JoinColumn(name = "office_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Office office;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "dev_id", length = 36)
    private String devId;

    @Column(name = "ip_address", length = 15)
    private String ipAddress;

    @Column(name = "type_id", length = 100)
    private String typeId;

    @Column(name = "table_name", length = 50)
    private String tableName;

    @Lob
    @Column(name = "data", columnDefinition = "text")
    private String data;

    @Lob
    @Column(name = "request", columnDefinition = "text")
    private String request;

}
