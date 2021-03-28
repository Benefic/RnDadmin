package ru.runanddone.admin.cron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.cron.model.CronJob;

@Repository
public interface CronJobRepository extends JpaRepository<CronJob, Integer> {
}
