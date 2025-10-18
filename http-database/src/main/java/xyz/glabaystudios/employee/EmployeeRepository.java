package xyz.glabaystudios.employee;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<@NotNull Employee, @NotNull String> {}