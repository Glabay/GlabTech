package xyz.glabaystudios.inter.impl;

import xyz.glabaystudios.dto.CustomerDeviceDto;
import xyz.glabaystudios.inter.DtoConverter;
import xyz.glabaystudios.device.CustomerDevice;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
public interface CustomerDeviceConverter extends DtoConverter<CustomerDevice, CustomerDeviceDto> {

    default CustomerDeviceDto mapToDto(CustomerDevice model) {
        return new CustomerDeviceDto(
            model.getDropOffId(),
            model.getCustomerId(),
            model.getDropOffDate(),
            model.getNotes()
        );
    }
}
