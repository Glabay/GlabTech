package xyz.glabaystudios.customer;

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
public class CustomerService implements CustomerConverter {

    private final CustomerRepository customerRepository;
    private final CustomerDeviceRepository customerDeviceRepository;

    public CustomerService(CustomerRepository customerRepository, CustomerDeviceRepository customerDeviceRepository) {
        this.customerRepository = customerRepository;
        this.customerDeviceRepository = customerDeviceRepository;
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }
}
