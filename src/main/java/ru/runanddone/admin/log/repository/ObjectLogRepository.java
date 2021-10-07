package ru.runanddone.admin.log.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.log.model.ObjectLog;

@Repository
public interface ObjectLogRepository extends JpaRepository<ObjectLog, Long> {
    @Query(
            value = "SELECT * FROM rd_obj_log",
            countQuery = "SELECT 100",
            nativeQuery = true)
    Page<ObjectLog> findAllWithPagination(Pageable pageable);
}
