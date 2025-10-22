package shop.devictoria.api.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import lombok.RequiredArgsConstructor;
import shop.devictoria.api.weather.service.WeatherService;
import shop.devictoria.api.weather.domain.WeatherDTO;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

@GetMapping("/weather")
public String getWeather(Model model) {
    System.out.println("=== WeatherController에서 날씨 데이터 출력 시작 ===");
    
    try {
        // CSV 파일 경로
        String csvFilePath = "src/main/resources/static/csv/TEST_weather_00.csv-Grid view.csv";
        
        // CSV 파일 읽기
        FileReader reader = new FileReader(csvFilePath);
        CSVParser parser = CSVFormat.DEFAULT.parse(reader);
        
        List<WeatherDTO> weatherList = new ArrayList<>();
        
        // 모든 데이터 읽기 (맨 위부터 맨 아래까지)
        boolean isFirstRecord = true;
        for (CSVRecord record : parser) {
            if (isFirstRecord) {
                isFirstRecord = false;
                continue; // 헤더 건너뛰기
            }
            
            WeatherDTO weather = new WeatherDTO();
            weather.setDate(record.get(0));
            weather.setTemperature(record.get(1));
            weather.setMaxTemperature(record.get(2));
            weather.setMaxTemperatureTime(record.get(3));
            weather.setMinTemperature(record.get(4));
            weather.setMinTemperatureTime(record.get(5));
            weather.setTemperatureDifference(record.get(6));
            weather.setPrecipitation(record.get(7));
            
            weatherList.add(weather);
        }
        
        parser.close();
        reader.close();
        
        // Model에 데이터 추가
        model.addAttribute("weatherList", weatherList);
        
        System.out.println("=== WeatherController에서 날씨 데이터 출력 완료 ===");
        
        return "weather/weatherlist";
        
    } catch (IOException e) {
        System.err.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        model.addAttribute("error", "날씨 데이터를 불러오는 중 오류가 발생했습니다.");
        return "weather/weatherlist";
    }
}
}