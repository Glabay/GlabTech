package xyz.glabaystudios.site_map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;
import xyz.glabaystudios.dto.UserCredentialsDto;
import xyz.glabaystudios.dto.UserProfileDto;
import xyz.glabaystudios.service.RegistrationService;
import xyz.glabaystudios.user.UserProfile;

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
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final RestClient restClient;

    @PostMapping("/new")
    public String registerNewUser(@ModelAttribute("newUser") UserCredentialsDto userCredentials) {
        if (Objects.isNull(userCredentials))
            return "redirect:/register?noCreds";
        if (registrationService.userExists(userCredentials))
            return "redirect:/register?userExists";
        if (!Objects.equals(userCredentials.password(), userCredentials.rePassword()))
            return "redirect:/register?passMissMatch";
        // Make a DTO of it, and fire it off to the backend to register it.
        var dto = new UserProfileDto(
            userCredentials.email(),
            userCredentials.username(),
            new BCryptPasswordEncoder().encode(userCredentials.password()),
            LocalDateTime.now(),
            LocalDateTime.now()
        );
        restClient.post()
            .uri("http://localhost:8080/api/v1/profile/register")
            .body(dto)
            .retrieve()
            .toEntity(String.class);
        // Reroute to the home page.
        return "redirect:/index";
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserProfileDto>> getAllUsers() {
        var dtos = registrationService.findAll();
        if (Objects.isNull(dtos) || dtos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(dtos);
    }
}
