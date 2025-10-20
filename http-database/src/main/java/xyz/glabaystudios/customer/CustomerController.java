package xyz.glabaystudios.customer;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.user.UserProfile;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    private ResponseEntity<@NotNull CustomerDto> createCustomer(@RequestBody @NotNull UserProfileDto dto) {
        return ResponseEntity.ok(customerService.createCustomer(dto));
    }

    @GetMapping("/{customerId}")
    private ResponseEntity<@NotNull CustomerDto> getCustomerById(@PathVariable String customerId) {
        var custId = Integer.parseInt(customerId);
        return ResponseEntity.ok(customerService.getCustomerById(custId));
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
