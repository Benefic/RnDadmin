package ru.runanddone.admin.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.items.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
}
