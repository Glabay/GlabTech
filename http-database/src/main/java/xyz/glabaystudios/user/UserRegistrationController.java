package xyz.glabaystudios.user;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.glabaystudios.dto.UserProfileDto;

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
            return new ResponseEntity<>("201:Successfully created profile.", HttpStatus.CREATED);
        return new ResponseEntity<>("204:Oops, looks like something we sideways...", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<UserProfile> findUser(@PathVariable String username) {
        var model = playerProfileService.findByUsername(username);
        if (Objects.isNull(model))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<@NotNull List<UserProfileDto>> findAllUsers() {
        var dtos = playerProfileService.findAll();
        if (Objects.isNull(dtos) || dtos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/exists/{username}")
    public ResponseEntity<Boolean> findAllUsers(@PathVariable String username) {
        var userExists = playerProfileService.userExists(username);
        if (Objects.isNull(userExists))
            return ResponseEntity.notFound().build();
        if (userExists)
            return ResponseEntity.ok().body(Boolean.TRUE);
        else
            return ResponseEntity.ok().body(Boolean.FALSE);
    }
}
