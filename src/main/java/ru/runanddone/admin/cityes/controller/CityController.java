package ru.runanddone.admin.cityes.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.cityes.service.CityService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Page<CityDto>> getAll(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        if (page <= 1) {
            page = 0;
        } else {
            page--;
        }

        return new ResponseEntity<>(cityService.getAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable String id) {
        return new ResponseEntity<>(cityService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityDto> add(@RequestBody CityDto city) {
        return new ResponseEntity<>(cityService.add(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        cityService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
