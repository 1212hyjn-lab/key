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
    private String weather;
    private String temperature;
    private String humidity;
    private String wind;
    private String precipitation;
    private String pressure;
    private String visibility;
    private String cloudiness;
    
}
