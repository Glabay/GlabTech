package xyz.glabaystudios.customer;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<@NotNull Customer, @NotNull Integer> {
}