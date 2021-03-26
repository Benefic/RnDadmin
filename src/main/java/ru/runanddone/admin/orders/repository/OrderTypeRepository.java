package ru.runanddone.admin.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.orders.model.OrderType;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Byte> {
}
