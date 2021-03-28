package ru.runanddone.admin.items.model;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class ItemMapper {

    private final ModelMapper mapper;

    public Item toEntity(ItemDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Item.class);
    }

    public ItemDto toDto(Item entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ItemDto.class);
    }
}
