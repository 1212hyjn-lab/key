package shop.devictoria.api.auth.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.devictoria.api.auth.domain.LoginDTO;
import shop.devictoria.api.auth.service.LoginService;

@Controller
public class LoginController {
    
    private final LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    
    @GetMapping("/auth/login/process")
    public String login(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        
        // 쿼리스트링 콘솔 출력
        System.out.println("로그인컨트롤러로 들어옴");
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        loginService.login(loginDTO);
        
        // 로그인 성공 시 홈페이지로 리다이렉트
        return "redirect:/";
    }
}
