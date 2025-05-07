package xyz.glabaystudios.site_map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.glabaystudios.dto.UserCredentialsDto;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Controller
@RequestMapping
public class HomePageController {

    @GetMapping({"/", "/index", "/home"})
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("newUser", new UserCredentialsDto("", "", "", ""));
        return "register";
    }
}
