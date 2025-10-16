package shop.devictoria.api.auth.service;
import org.springframework.stereotype.Service;
import shop.devictoria.api.auth.domain.LoginDTO;
import shop.devictoria.api.auth.domain.LoginVO;
import shop.devictoria.api.common.domain.Messenger;

@Service
public class LoginService {
    
    public Messenger login(LoginDTO loginDTO) {
        // 간단한 로그인 로직 (실제로는 데이터베이스 검증 필요)
        System.out.println("로그인 서비스 호출됨");
        System.out.println("DTO 에서 서비스로 전달된 이메일: " + loginDTO.getEmail());
        System.out.println("DTO 에서 서비스로 전달된 비밀번호: " + loginDTO.getPassword());
        
        LoginVO loginVO = new LoginVO();
        
        System.out.println("VO 에서 서비스로 전달된 이메일: " + loginVO.getEmail());
        System.out.println("VO 에서 서비스로 전달된 비밀번호: " + loginVO.getPassword());
       
     
        if (loginVO.getEmail().equals(loginDTO.getEmail()) && loginVO.getPassword().equals(loginDTO.getPassword())) {
            int code = 0;
            String message = "로그인 성공";

        } else if (loginVO.getEmail().equals(loginDTO.getEmail()) && !loginVO.getPassword().equals(loginDTO.getPassword())) {
              int code = 2;
    String message = "비밀번호 불일치";
        }
        else {
            int code = 1;
            String message = "이메일 불일치";
        }
        
    
        }
      Messenger messenger = new Messenger();
      messenger.setCode(code);
      messenger.setMessage(message);
      return messenger;
    
        
    }
