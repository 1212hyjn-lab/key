package shop.devictoria.api.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {   
  
    private String date;
    private String temperature;           // 평균기온
    private String maxTemperature;       // 최고기온
    private String maxTemperatureTime;    // 최고기온시각
    private String minTemperature;       // 최저기온
    private String minTemperatureTime;    // 최저기온시각
    private String temperatureDifference; // 일교차
    private String precipitation;         // 강수량
    
    // 기존 필드들 (호환성을 위해 유지)
    private String weather;
    private String humidity;
    private String wind;
    private String pressure;
    private String visibility;
    private String cloudiness;
    
}
