package xyz.glabaystudios.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.glabaystudios.dto.CustomerDeviceDto;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.service.CustomerDeviceService;
import xyz.glabaystudios.service.CustomerService;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDeviceService customerDeviceService;

    @GetMapping("/search/all")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/devices/search/all")
    public List<CustomerDeviceDto> getAllCustomerDevices() {
        return customerDeviceService.getAllCustomerDevices();
    }

    @GetMapping("/devices/search/param")
    public List<CustomerDeviceDto> getCustomerDevices(@RequestParam Integer customerId) {
        return customerDeviceService.getCustomerDevices(customerId);
    }
}
