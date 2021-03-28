package ru.runanddone.admin.cron.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rd_cron")
public class CronJob {
    @Id
    private int id;
    private String name;
    private String schedule;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Column(columnDefinition = "TEXT")
    private String scriptPath;
    private LocalDateTime lastExecution;
    private LocalDateTime nextExecution;
    private boolean active;
    private boolean error;
    @Column(columnDefinition = "TEXT")
    private String report;
}
