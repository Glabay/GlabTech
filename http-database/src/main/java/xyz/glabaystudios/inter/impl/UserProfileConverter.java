package xyz.glabaystudios.inter.impl;

import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.inter.DtoConverter;
import xyz.glabaystudios.user.UserProfile;

import java.time.LocalDateTime;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-22
 */
public interface UserProfileConverter extends DtoConverter<UserProfile, UserProfileDto> {
    @Override
    default UserProfileDto mapToDto(UserProfile model) {
        return new UserProfileDto(
            model.getEmail(),
            model.getUsername(),
            model.getEncryptedPassword(),
            model.getCreatedAt(),
            LocalDateTime.now()
        );
    }
}
