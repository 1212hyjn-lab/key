package shop.devictoria.api.weather.repository;

import org.springframework.stereotype.Repository;

import shop.devictoria.api.weather.domain.WeatherDTO;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WeatherRepository {

    public void printSampleWeather() {
        List<WeatherDTO> weathers = getSampleWeather();
        System.out.println("=== 날씨 데이터 전체 내용 ===");
        for (int i = 0; i < weathers.size() && i < 10; i++) {
            WeatherDTO weather = weathers.get(i);
            System.out.println("일시: " + weather.getDate());
            System.out.println("날씨: " + weather.getWeather());
            System.out.println("온도: " + weather.getTemperature() + "℃");
            System.out.println("습도: " + weather.getHumidity() + "%");
            System.out.println("바람: " + weather.getWind() + "m/s");
            System.out.println("강수량: " + weather.getPrecipitation() + "mm");
            System.out.println("기압: " + weather.getPressure() + "hPa");
            System.out.println("가시거리: " + weather.getVisibility() + "km");
            System.out.println("구름량: " + weather.getCloudiness() + "%");
            System.out.println("--------------------------------");
        }
    }

    public List<WeatherDTO> getSampleWeather() {
        List<WeatherDTO> weathers = new ArrayList<>();
        
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/TEST_weather_00.csv-Grid view.csv";
            
            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);
            
            // 모든 데이터 읽기 (맨 위부터 맨 아래까지)
            boolean isFirstRecord = true;
            for (CSVRecord record : parser) {
                if (isFirstRecord) {
                    isFirstRecord = false;
                    continue; // 헤더 건너뛰기
                }
                
                WeatherDTO weather = new WeatherDTO();
                weather.setDate(record.get(0)); // 첫 번째 컬럼 (일시)
                weather.setWeather("맑음"); // CSV에 날씨 정보가 없으므로 기본값
                weather.setTemperature(record.get(1)); // 두 번째 컬럼 (평균기온)
                weather.setHumidity("60"); // 기본값
                weather.setWind("5"); // 기본값
                weather.setPrecipitation(record.get(7)); // 여덟 번째 컬럼 (강수량)
                weather.setPressure("1013"); // 기본값
                weather.setVisibility("10"); // 기본값
                weather.setCloudiness("30"); // 기본값
                
                weathers.add(weather);
            }
            
            parser.close();
            reader.close();
            
        } catch (IOException e) {
            System.err.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        return weathers;
    }
    
}
