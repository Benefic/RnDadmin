package ru.runanddone.admin.cityes.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.cityes.service.CityService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(cityService.getAll(page, size).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDto> add(@RequestBody CityDto city) {
        return new ResponseEntity<>(cityService.add(city), HttpStatus.OK);
    }
}
