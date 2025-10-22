package shop.devictoria.api.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherVO {   
  
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
