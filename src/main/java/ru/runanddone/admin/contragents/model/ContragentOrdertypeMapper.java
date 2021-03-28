package ru.runanddone.admin.contragents.model;

import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.runanddone.admin.contragents.repository.ContragentRepository;
import ru.runanddone.admin.orders.model.OrderType;
import ru.runanddone.admin.orders.model.OrderTypeDto;
import ru.runanddone.admin.orders.repository.OrderTypeRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@AllArgsConstructor
@Component
public class ContragentOrdertypeMapper {

    private final ModelMapper mapper;
    private final ContragentRepository contragentRepository;
    private final OrderTypeRepository orderTypeRepository;

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ContragentOrdertype.class, ContragentOrdertypeDto.class)
                .addMappings(m -> m.skip(ContragentOrdertypeDto::setContragent))
                .addMappings(m -> m.skip(ContragentOrdertypeDto::setOrderType))
                .setPostConverter(toDtoConverter());
    }

    private Converter<ContragentOrdertype, ContragentOrdertypeDto> toDtoConverter() {
        return context -> {
            ContragentOrdertype source = context.getSource();
            ContragentOrdertypeDto destination = context.getDestination();
            mapContragent(source, destination);
            mapOrderType(source, destination);
            return context.getDestination();
        };
    }

    private void mapContragent(ContragentOrdertype source, ContragentOrdertypeDto destination) {
        if (source.getKey().contragentId != null) {
            Contragent contragent = contragentRepository.findById(source.getKey().contragentId).orElse(null);
            destination.setContragent(mapper.map(contragent, ContragentDto.class));
        }
    }

    private void mapOrderType(ContragentOrdertype source, ContragentOrdertypeDto destination) {
        OrderType orderType = orderTypeRepository.findById(source.getKey().ordertypeId).orElse(null);
        destination.setOrderType(mapper.map(orderType, OrderTypeDto.class));

    }

    public ContragentOrdertype toEntity(ContragentOrdertypeDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, ContragentOrdertype.class);
    }

    public ContragentOrdertypeDto toDto(ContragentOrdertype entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ContragentOrdertypeDto.class);
    }
}
