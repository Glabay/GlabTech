package xyz.glabaystudios.site_map;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-05-06
 */
@Controller
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RestClient restClient;

    public RegistrationController(RestClient restClient) {
        this.restClient = restClient;
    }

    @PostMapping("/new")
    public String registerNewUser(@ModelAttribute("newUser") UserCredentialsDto userCredentials) {
        if (Objects.isNull(userCredentials))
            return "redirect:/register?noCreds";
        if (userExists(userCredentials.username()))
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
    public ResponseEntity<@NotNull List<UserProfileDto>> getAllUsers() {
        var dtos = restClient.get()
            .uri("http://localhost:8080/api/v1/profile/all")
            .retrieve()
            .toEntity(new ParameterizedTypeReference<@NotNull List<UserProfileDto>>() {})
            .getBody();
        if (Objects.isNull(dtos) || dtos.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(new ArrayList<>(dtos), HttpStatus.OK);
    }

    private boolean userExists(String username) {
        try {
            var response = restClient.get()
                .uri("http://localhost:8080/api/v1/profile/exists/{username}", username)
                .retrieve()
                .body(Boolean.class);
            return Boolean.TRUE.equals(response);
        }
        catch (Exception e) {
            return false;
        }
    }

}
