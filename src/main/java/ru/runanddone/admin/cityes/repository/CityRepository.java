package ru.runanddone.admin.cityes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.cityes.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
