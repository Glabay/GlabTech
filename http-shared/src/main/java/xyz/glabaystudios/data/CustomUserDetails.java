package xyz.glabaystudios.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.glabaystudios.user.UserProfile;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
public class CustomUserDetails implements UserDetails {

    private final UserProfile userProfile;

    public CustomUserDetails(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = new ArrayList<SimpleGrantedAuthority>();
        // Everyone gets the default USER role
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        var roleManager = new SimpleGrantedAuthority("ROLE_MANAGEMENT");
        var roleDeveloper = new SimpleGrantedAuthority("ROLE_DEVELOPER");
        var roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");


        return authorities;
    }

    @Override
    public String getPassword() {
        return userProfile.getEncryptedPassword();
    }

    @Override
    public String getUsername() {
        return userProfile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
