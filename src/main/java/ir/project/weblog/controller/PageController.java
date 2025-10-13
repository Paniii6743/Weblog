package ir.project.weblog.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/showAllPosts")
    public String showAllPosts() {
        return "showAllPosts";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/savePost")
    public String savePost() {
        return "savePost";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/editPost")
    public String editPost() {
        return "editPost";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/listPosts")
    public String listPosts() {
        return "listPosts";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/saveCategory")
    public String saveCategory() {
        return "saveCategory";
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/listUsers")
    public String listUsers() {
        return "listUsers";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/listComments")
    public String listComments() {
        return "listComments";
    }

    @GetMapping("/403")
    public String accessDen() {
        return "403";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}

