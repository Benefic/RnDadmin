package ru.runanddone.admin.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runanddone.admin.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
