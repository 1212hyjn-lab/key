package shop.devictoria.api.weather.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import shop.devictoria.api.common.domain.Messenger;
import shop.devictoria.api.weather.repository.WeatherRepository;

@Service
@RequiredArgsConstructor
public class WeatherService {
private final WeatherRepository weatherRepository;

@PostConstruct
public void init() {
    System.out.println("=== WeatherService 초기화 시작 ===");
    weatherRepository.printSampleWeather();
    System.out.println("=== WeatherService 초기화 완료 ===");
}
    public Messenger getWeather() {
        weatherRepository.printSampleWeather();
        
        Messenger messenger = new Messenger();
        messenger.setCode(0);
        messenger.setMessage("날씨 데이터 출력 완료");
        return messenger;
    }



}
