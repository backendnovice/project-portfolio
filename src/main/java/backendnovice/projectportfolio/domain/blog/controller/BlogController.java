package backendnovice.projectportfolio.domain.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @GetMapping("/home")
    public String getHomeForm() {
        return "/blog/home";
    }
}
