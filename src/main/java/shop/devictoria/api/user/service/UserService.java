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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirstFivePassengers'");
    }
}

