package xyz.glabaystudios.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.glabaystudios.dto.ServiceDto;
import xyz.glabaystudios.service.ServicesService;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/service")
public class ServiceController {
    public final ServicesService servicesService;

    @GetMapping("/search/all")
    public List<ServiceDto> getAllServices() {
        return servicesService.getAllServices();
    }
}
