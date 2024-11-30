package xyz.glabaystudios.device;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDeviceRepository extends JpaRepository<CustomerDevice, Integer> {
    List<CustomerDevice> findByCustomerId(Integer customerId);
}