package xyz.glabaystudios.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.glabaystudios.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {}