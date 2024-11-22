package xyz.glabaystudios.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.glabaystudios.model.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {
}