package xyz.glabaystudios.site_map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Glabay | Glabay-Studios
 * @project GlabTech
 * @social Discord: Glabay
 * @since 2024-11-30
 */
@Controller
@RequestMapping
public class SiteMapController {

    @GetMapping({"/", "/index", "/home"})
    public String getHomePage() {
        return "index";
    }
}
