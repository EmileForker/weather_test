package services.weather.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface WeatherEndpoints {
  @Headers({"Accept: application/json"})
  @GET("v2/forecast")
  Call<ResponseBody> getWeather(
      @Query("lat") double latitude,
      @Query("lon") double longitude,
      @Query("lang") String lang,
      @Header("X-Yandex-API-Key") String key);
}
