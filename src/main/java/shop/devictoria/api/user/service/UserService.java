package shop.devictoria.api.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.devictoria.api.common.domain.Messenger;
import shop.devictoria.api.user.domain.UserDTO;
import shop.devictoria.api.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

@PostConstruct
public void init() {
    System.out.println("=== UserService 초기화 시작 ===");
    // Service는 단순히 Repository와 연결만 함
    userRepository.printSamplePassengers();
    System.out.println("=== UserService 초기화 완료 ===");
}

    public Messenger getFirstFivePassengers(List<UserDTO> users) {
        System.out.println("=== UserService에서 승객 데이터 처리 시작 ===");
        
        // 승객 데이터 처리 로직
        for (UserDTO user : users) {
            System.out.println("승객 ID: " + user.getPassengerId() + 
                            ", 이름: " + user.getName() + 
                            ", 생존: " + (user.getSurvived().equals("1") ? "생존" : "사망"));
        }
        
        System.out.println("=== UserService에서 승객 데이터 처리 완료 ===");
        
        // 성공 메시지 반환
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("승객 데이터를 성공적으로 처리했습니다. 총 " + users.size() + "명의 승객 정보를 표시합니다.");
        return messenger;
    }
}

