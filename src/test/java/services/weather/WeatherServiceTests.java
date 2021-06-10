package services.weather;

import org.testng.annotations.Test;
import services.weather.api.WeatherFunctions;
import services.weather.api.models.ForecastResponse;

public class WeatherServiceTests {

  @Test(description = "required data test")
  public void getWeatherRequiredDataTest() {

    final String key = System.getenv("YANDEX_WEATHER_API_KEY");

    final double lat = 55.757131;
    final double lon = 37.617114;

    WeatherFunctions weatherFunctions = new WeatherFunctions();
    ForecastResponse forecastResponse = weatherFunctions.getWeatherByPoints(lat, lon, "en_US", key);

    WeatherServiceAsserts.assertReturnedLocationIsValid(forecastResponse, lat, lon);
    WeatherServiceAsserts.assertResponseHasRequiredData(forecastResponse);
  }
}
