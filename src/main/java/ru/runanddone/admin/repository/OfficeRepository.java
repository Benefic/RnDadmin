package ru.runanddone.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.model.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
