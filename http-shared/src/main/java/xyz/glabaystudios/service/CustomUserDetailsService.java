package xyz.glabaystudios.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.data.CustomUserDetails;
import xyz.glabaystudios.net.IClient;
import xyz.glabaystudios.user.UserProfile;

import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Service
public class CustomUserDetailsService implements UserDetailsService, IClient {

    @Override
    public @NotNull UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        var profile = getRestClient().get()
            .uri(API_URL.concat("/v1/profiles/find/").concat(username))
            .retrieve()
            .toEntity(UserProfile.class)
            .getBody();
        if (Objects.isNull(profile))
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetails(profile);
    }
}
