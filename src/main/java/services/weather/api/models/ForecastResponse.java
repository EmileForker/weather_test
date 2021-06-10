package services.weather.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ForecastResponse {

  @SerializedName("now")
  private long ts;

  @SerializedName("now_dt")
  private String dateTime;

  @SerializedName("info")
  private final Info info;

  @SerializedName("fact")
  private final Fact fact;

  @Getter
  @AllArgsConstructor
  public static class Info {

    @SerializedName("lat")
    private final double latitude;

    @SerializedName("lon")
    private final double longitude;
  }

  @Getter
  @AllArgsConstructor
  public static class Fact {

    @SerializedName("temp")
    private final Integer temperature;

    @SerializedName("cloudness")
    private final double cloudness;

    @SerializedName("humidity")
    private final Integer humidity;

    @SerializedName("season")
    private final String season;
  }
}
