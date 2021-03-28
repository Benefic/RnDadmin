package ru.runanddone.admin.cron.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.runanddone.admin.cron.model.CronJobDto;
import ru.runanddone.admin.cron.service.CronJobService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cronjobs")
public class CronJobController {
    private final CronJobService service;

    @GetMapping
    public ResponseEntity<List<CronJobDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(service.getAll(page, size).getContent(), HttpStatus.OK);
    }
}
