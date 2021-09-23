package ru.runanddone.admin.devices.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.runanddone.admin.devices.model.DeviceDto;
import ru.runanddone.admin.devices.service.DeviceService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final DeviceService service;

    @GetMapping
    public ResponseEntity<Page<DeviceDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(service.getAll(page, size), HttpStatus.OK);
    }
}
