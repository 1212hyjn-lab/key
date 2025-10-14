package shop.devictoria.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/auth/login.html")
    public String LoginHtml() {
        return "auth/login";
    }

    @GetMapping("/auth/register.html")
    public String RegisterHtml() {
        return "auth/register";
    }

    @GetMapping("/plus")
    public String plus() {
        return "contents/calculator/plus";
    }
    
    @GetMapping("/nanum")
    public String nanum() {
        return "contents/calculator/nanum";
    }
    
    @GetMapping("/minus")
    public String minus() {
        return "contents/calculator/minus";
    }
    
    @GetMapping("/gob")
    public String gob() {
        return "contents/calculator/gob";
    }
    
   
}
