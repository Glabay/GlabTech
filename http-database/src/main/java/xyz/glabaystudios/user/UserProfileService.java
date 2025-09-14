package xyz.glabaystudios.user;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.inter.impl.UserProfileConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-05-06
 */
@Service
@RequiredArgsConstructor
public class UserProfileService implements UserProfileConverter {
    private final UserProfileRepository playerProfileRepository;

    public UserProfile createNewPlayerProfile(UserProfileDto dto) {
        var creation = new UserProfile();
            creation.setUsername(dto.username());
            creation.setEmail(dto.email());
            creation.setEncryptedPassword(dto.encryptedPassword());
            creation.setUpdatedAt(java.time.LocalDateTime.now());
        return playerProfileRepository.saveAndFlush(creation);
    }

    public UserProfile findByUsername(String username) {
        return playerProfileRepository.findByUsernameIgnoreCase(username).orElse(null);
    }

    public List<UserProfileDto> findAll() {
        var profiles = playerProfileRepository.findAll();
        return profiles.stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    public @Nullable Boolean userExists(String username) {
        return playerProfileRepository.existsByUsernameIgnoreCase(username);
    }
}
