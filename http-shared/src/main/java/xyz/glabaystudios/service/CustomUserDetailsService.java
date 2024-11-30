package xyz.glabaystudios.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.glabaystudios.data.CustomUserDetails;

import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RegistrationService registrationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var profile = registrationService.findByUsername(username);
        if (Objects.nonNull(profile))
            return new CustomUserDetails(profile);
        throw new UsernameNotFoundException("User not found.");
    }
}
