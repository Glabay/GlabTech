package xyz.glabaystudios.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.glabaystudios.model.CustomerDevice;

public interface CustomerDeviceRepository extends JpaRepository<CustomerDevice, Integer> {
}