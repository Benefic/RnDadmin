package ru.runanddone.admin.cron.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CronJobDto {
    private int id;
    private String name;
    private String schedule;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String scriptPath;
    private LocalDateTime lastExecution;
    private LocalDateTime nextExecution;
    private boolean active;
    private boolean error;
    private String report;
}
