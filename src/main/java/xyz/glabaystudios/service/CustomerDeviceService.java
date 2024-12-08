package xyz.glabaystudios.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.CustomerDeviceDto;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.inter.impl.CustomerConverter;
import xyz.glabaystudios.inter.impl.CustomerDeviceConverter;
import xyz.glabaystudios.repo.CustomerDeviceRepository;
import xyz.glabaystudios.repo.CustomerRepository;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
@Service
@RequiredArgsConstructor
public class CustomerDeviceService implements CustomerDeviceConverter {

    private final CustomerDeviceRepository customerDeviceRepository;

    public List<CustomerDeviceDto> getAllCustomerDevices() {
        return customerDeviceRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }

    public List<CustomerDeviceDto> getCustomerDevices(Integer customerId) {
        return customerDeviceRepository.findByCustomerId(customerId)
            .stream()
            .map(this::mapToDto)
            .toList();
    }
}
