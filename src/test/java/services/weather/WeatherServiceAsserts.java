package services.weather;

import org.assertj.core.api.SoftAssertions;
import services.weather.api.models.ForecastResponse;

public class WeatherServiceAsserts {

  private WeatherServiceAsserts() {}

  public static void assertReturnedLocationIsValid(
      ForecastResponse forecastResponse, double expectedLatitude, double expectedLongitude) {
    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(forecastResponse.getInfo().getLatitude()).isEqualTo(expectedLatitude);
          softly.assertThat(forecastResponse.getInfo().getLongitude()).isEqualTo(expectedLongitude);
        });
  }

  public static void assertResponseHasRequiredData(ForecastResponse forecastResponse) {
    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(forecastResponse.getTs()).isNotNull();
          softly.assertThat(forecastResponse.getDateTime()).isNotNull();
          softly.assertThat(forecastResponse.getFact().getSeason()).isEqualTo("summer");
          softly.assertThat(forecastResponse.getFact().getTemperature()).isNotNull();
          softly.assertThat(forecastResponse.getFact().getCloudness()).isNotNull();
          softly.assertThat(forecastResponse.getFact().getHumidity()).isNotNull();
        });
  }
}
