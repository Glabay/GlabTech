package xyz.glabaystudios.dto;

import java.util.Date;

/**
 * @author Glaba
 * @project GlabTech
 * @social Discord: Glabay | GitHub: github.com/glabay
 * @since 2024-11-22
 */
public record CustomerDeviceDto(
    Integer dropOffId,
    String customerId,
    Date dropOffDate,
    String notes
) {}