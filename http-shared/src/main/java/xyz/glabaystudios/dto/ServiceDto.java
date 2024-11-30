package xyz.glabaystudios.dto;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record ServiceDto(
    String serviceName,
    String serviceDescription,
    double servicePrice,
    boolean fixedRate
) {}