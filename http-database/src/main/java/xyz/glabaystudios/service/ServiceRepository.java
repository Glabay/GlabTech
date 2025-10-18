package xyz.glabaystudios.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<@NotNull Service, @NotNull String> {
}