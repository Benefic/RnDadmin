package ru.runanddone.admin.log.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.runanddone.admin.log.model.ObjectLogDto;
import ru.runanddone.admin.log.service.ObjectLogService;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class ObjectLogController {

    private final ObjectLogService service;

    @GetMapping
    public Page<ObjectLogDto> getAll(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "25") Integer size,
                                     @RequestParam(defaultValue = "time") String sortBy,
                                     @RequestParam(defaultValue = "ASC") Sort.Direction direction) {
        Sort sort;
        if (direction.isAscending()) {
            sort = Sort.by(Sort.Order.by(sortBy)).ascending();
        } else {
            sort = Sort.by(Sort.Order.by(sortBy)).descending();
        }
        return service.getAll(PageRequest.of(page - 1, size, sort));
    }

}
