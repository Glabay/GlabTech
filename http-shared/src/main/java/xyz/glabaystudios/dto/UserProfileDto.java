package xyz.glabaystudios.dto;

import java.time.LocalDateTime;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
public record UserProfileDto(
    String email,
    String firstName,
    String lastName,
    String contactNumber,
    String encryptedPassword,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}