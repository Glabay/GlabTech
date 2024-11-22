package xyz.glabaystudios.inter.impl;

import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.inter.DtoConverter;
import xyz.glabaystudios.model.Customer;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
public interface CustomerConverter extends DtoConverter<Customer, CustomerDto> {
    @Override
    default CustomerDto mapToDto(Customer model) {
        return new CustomerDto(
            model.getFirstName(),
            model.getLastName(),
            model.getEmail(),
            model.getContactNumber()
        );
    }
}
