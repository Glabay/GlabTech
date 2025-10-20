package xyz.glabaystudios.customer;

import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.inter.impl.CustomerConverter;
import xyz.glabaystudios.device.CustomerDeviceRepository;
import xyz.glabaystudios.user.UserProfile;

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

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
            .map(this::mapToDto)
            .orElse(null);
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .toList();
    }

    public CustomerDto createCustomer(@NotNull UserProfileDto dto) {
        var customer = new Customer();
            customer.setContactNumber(dto.contactNumber());
            customer.setFirstName(dto.firstName());
            customer.setLastName(dto.lastName());
            customer.setEmail(dto.email());
        // save the custeromer
        customerRepository.saveAndFlush(customer);
        return mapToDto(customer);
    }
}
