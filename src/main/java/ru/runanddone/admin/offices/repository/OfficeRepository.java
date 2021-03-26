package ru.runanddone.admin.offices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.offices.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Byte> {
}
