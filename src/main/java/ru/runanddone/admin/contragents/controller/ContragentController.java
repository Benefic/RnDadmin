package ru.runanddone.admin.contragents.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.contragents.service.ContragentService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/contragents")
public class ContragentController {

    private final ContragentService service;

    @GetMapping
    public ResponseEntity<Page<ContragentDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(service.getAll(page, size), HttpStatus.OK);
    }
}
