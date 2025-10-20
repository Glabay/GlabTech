package xyz.glabaystudios.dto;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
public record UserCredentialsDto(
    String firstName,
    String lastName,
    String contactNumber,
    String email,
    String password,
    String rePassword
) {}
