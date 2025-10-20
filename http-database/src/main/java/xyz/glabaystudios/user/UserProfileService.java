package xyz.glabaystudios.user;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.inter.impl.UserProfileConverter;
import xyz.glabaystudios.net.IClient;

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
public class UserProfileService implements UserProfileConverter, IClient {
    private final UserProfileRepository playerProfileRepository;

    public UserProfile createNewPlayerProfile(UserProfileDto dto) {
        var creation = new UserProfile();
            creation.setEmail(dto.email());
            creation.setFirstName(dto.firstName());
            creation.setLastName(dto.lastName());
            creation.setContactNumber(dto.contactNumber());
            creation.setEncryptedPassword(dto.encryptedPassword());
            creation.setUpdatedAt(java.time.LocalDateTime.now());
        // post a creation of a Customer Profile
        getRestClient().post()
            .uri(API_URL.concat("/v1/customers"))
            .body(creation);
        return playerProfileRepository.saveAndFlush(creation);
    }

    public List<UserProfileDto> findAll() {
        var profiles = playerProfileRepository.findAll();
        return profiles.stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    public UserProfileDto findByEmail(String email) {
        var profiles = playerProfileRepository.findByEmailIgnoreCase(email);
        return profiles.map(this::mapToDto)
            .orElse(null);
    }


    public @Nullable Boolean userExists(String username) {
        return playerProfileRepository.existsByFirstNameIgnoreCase(username);
    }
}
