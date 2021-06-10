package services.weather.api;

import helpers.ContentType;
import helpers.Validator;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_OK;

public class WeatherManager {

  static Response<ResponseBody> getWeatherByGeo(
      WeatherEndpoints weatherEndpoints, double lat, double lon, String lang, String key) {
    Call<ResponseBody> call = weatherEndpoints.getWeather(lat, lon, lang, key);
    return Validator.validateResponse(call, HTTP_OK, ContentType.JSON, "get weather by geo");
  }
}
