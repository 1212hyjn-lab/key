package shop.devictoria.api.weather.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import lombok.RequiredArgsConstructor;
import shop.devictoria.api.common.domain.Messenger;
import shop.devictoria.api.weather.service.WeatherService;

import java.io.FileReader;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

@GetMapping("/weather")
public Messenger getWeather() {
    System.out.println("=== WeatherController에서 날씨 데이터 출력 시작 ===");
    
    try {
        // CSV 파일 경로
        String csvFilePath = "src/main/resources/static/csv/TEST_weather_00.csv-Grid view.csv";
        
        // CSV 파일 읽기
        FileReader reader = new FileReader(csvFilePath);
        CSVParser parser = CSVFormat.DEFAULT.parse(reader);
        
        System.out.println("=== 날씨 데이터 전체 내용 ===");
        
        // 모든 데이터 읽기 (맨 위부터 맨 아래까지)
        boolean isFirstRecord = true;
        for (CSVRecord record : parser) {
            if (isFirstRecord) {
                isFirstRecord = false;
                continue; // 헤더 건너뛰기
            }
            
            System.out.println("일시: " + record.get(0));
            System.out.println("평균기온: " + record.get(1) + "℃");
            System.out.println("최고기온: " + record.get(2) + "℃");
            System.out.println("최고기온시각: " + record.get(3));
            System.out.println("최저기온: " + record.get(4) + "℃");
            System.out.println("최저기온시각: " + record.get(5));
            System.out.println("일교차: " + record.get(6));
            System.out.println("강수량: " + record.get(7) + "mm");
            System.out.println("--------------------------------");
        }
        
        parser.close();
        reader.close();
        
        System.out.println("=== WeatherController에서 날씨 데이터 출력 완료 ===");
        
        Messenger messenger = weatherService.getWeather();
        return messenger;
        
    } catch (IOException e) {
        Messenger messenger = new Messenger();
        messenger.setCode(1);
        messenger.setMessage("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        return messenger;
    }
}
}