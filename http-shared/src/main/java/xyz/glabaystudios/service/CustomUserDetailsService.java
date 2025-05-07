package xyz.glabaystudios.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import xyz.glabaystudios.data.CustomUserDetails;
import xyz.glabaystudios.user.UserProfile;

import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final RestClient restClient;

    public CustomUserDetailsService() {
        this.restClient = RestClient.builder()
            .requestFactory(new JdkClientHttpRequestFactory())
            .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var profile = restClient.get()
            .uri("http://localhost:8080/api/v1/profile/find/" + username)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntity(UserProfile.class)
            .getBody();
        if (Objects.isNull(profile))
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetails(profile);
    }
}
