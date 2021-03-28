package ru.runanddone.admin.items.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.runanddone.admin.items.model.ItemDto;
import ru.runanddone.admin.items.service.ItemService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService service;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(service.getAll(page, size).getContent(), HttpStatus.OK);
    }
}
