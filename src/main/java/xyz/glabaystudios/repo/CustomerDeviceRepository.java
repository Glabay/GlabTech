package xyz.glabaystudios.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.glabaystudios.model.CustomerDevice;

import java.util.List;

public interface CustomerDeviceRepository extends JpaRepository<CustomerDevice, Integer> {
    List<CustomerDevice> findByCustomerId(Integer customerId);
}