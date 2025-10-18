package xyz.glabaystudios.device;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDeviceRepository extends JpaRepository<@NotNull CustomerDevice, @NotNull Integer> {
    List<CustomerDevice> findByCustomerId(Integer customerId);
}