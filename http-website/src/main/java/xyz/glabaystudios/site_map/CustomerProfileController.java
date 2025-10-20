package xyz.glabaystudios.site_map;

import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.glabaystudios.dto.CustomerDto;
import xyz.glabaystudios.net.IClient;
import xyz.glabaystudios.user.UserProfile;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2025-10-20
 */
@Controller
@RequestMapping("/profile")
public class CustomerProfileController implements IClient {

    @GetMapping
    public String getProfilePage(HttpServletRequest request, Model model) {
        var username = request.getRemoteUser();
        System.out.println(username);
        return "customer_profile";
    }
}
