package xyz.glabaystudios.inter.impl;

import xyz.glabaystudios.dto.ServiceDto;
import xyz.glabaystudios.inter.DtoConverter;
import xyz.glabaystudios.model.Service;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
public interface ServiceConverter extends DtoConverter<Service, ServiceDto> {
    @Override
    default ServiceDto mapToDto(Service model) {
        return new ServiceDto(
            model.serviceName(),
            model.serviceDescription(),
            model.servicePrice(),
            model.fixedRate()
        );
    }
}
