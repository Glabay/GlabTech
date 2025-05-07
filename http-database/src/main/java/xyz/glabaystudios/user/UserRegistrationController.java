package xyz.glabaystudios.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import xyz.glabaystudios.dto.UserCredentialsDto;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.service.RegistrationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-05-06
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class UserRegistrationController {
    private final UserProfileService playerProfileService;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserProfileDto body) {
        if (Objects.isNull(body))
            return new ResponseEntity<>("405:Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
        var profile = playerProfileService.createNewPlayerProfile(body);
        if (Objects.nonNull(profile))
            return new ResponseEntity<>("201:Successfully created profile -> " + profile.getUsername(), HttpStatus.CREATED);
        return new ResponseEntity<>("204:Oops, looks like something we sideways...", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<UserProfile> findUser(@PathVariable String username) {
        var model = playerProfileService.findByUsername(username);
        if (Objects.isNull(model))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
