package ru.runanddone.admin.items.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.runanddone.admin.items.model.ItemDto;
import ru.runanddone.admin.items.model.ItemMapper;
import ru.runanddone.admin.items.repository.ItemRepository;

@AllArgsConstructor
@Service
public class ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper;

    public Page<ItemDto> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("name"))).map(mapper::toDto);
    }
}
