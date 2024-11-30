package xyz.glabaystudios.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.inter.impl.CustomerConverter;
import xyz.glabaystudios.device.CustomerDeviceRepository;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerConverter {

    private final CustomerRepository customerRepository;
    private final CustomerDeviceRepository customerDeviceRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }
}
