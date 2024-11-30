package xyz.glabaystudios.service;


import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.UserCredentialsDto;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.user.UserProfile;
import xyz.glabaystudios.user.UserProfileRepository;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserProfileRepository userProfileRepository;

    public UserProfile findByUsername(String username) {
        return userProfileRepository.findByUsernameIgnoreCase(username).orElse(null);
    }

    public boolean userExists(@NotNull UserCredentialsDto dto) {
        return userProfileRepository.existsByUsernameIgnoreCase(dto.getUsername());
    }

    public UserProfile saveNew(UserProfile model) {
        return userProfileRepository.saveAndFlush(model);
    }

    public List<UserProfileDto> findAll() {
        return userProfileRepository.findAll()
            .stream().map(this::toDto)
            .toList();
    }

    @Contract("_ -> new")
    private @NotNull UserProfileDto toDto(@NotNull UserProfile model) {
        return new UserProfileDto(
            model.getUsername(),
            model.getEncryptedPassword(),
            model.getEmail(),
            model.getCreatedAt(),
            model.getUpdatedAt());
    }
}
