package xyz.glabaystudios.site_map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.glabaystudios.data.CustomUserDetails;
import xyz.glabaystudios.dto.UserCredentialsDto;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error,
                        @RequestParam(required = false) String logout,
                        Model model
    ) {
        // If user's already authenticated, redirect to home page
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() &&
            auth.getPrincipal() instanceof CustomUserDetails) {
            return "redirect:/index";
        }
        // Add error message if login failed
        if (error != null)
            model.addAttribute("error", "Invalid username or password");
        // Add logout message if user just logged out
        if (logout != null)
            model.addAttribute("message", "You have been successfully logged out");


        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
            model.addAttribute("username", userDetails.getUsername());
        }
        return "redirect:/";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "redirect:error?errorCode=403&errorText=Forbidden";
    }


}
