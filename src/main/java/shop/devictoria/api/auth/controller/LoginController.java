package shop.devictoria.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    
    @GetMapping("/auth/login")
    public String login(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password) {
        
        // 쿼리스트링 콘솔 출력
        System.out.println("name = " + email);
        System.out.println("name = " + password);
        
        return "auth/login";
    }
}
