package services.weather.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.weather.api.models.ForecastResponse;

import java.io.IOException;

public class WeatherFunctions {

  private WeatherEndpoints weatherEndpoints;

  public WeatherFunctions() {

    final String baseUrl = "https://api.weather.yandex.ru/";

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client).build();
    weatherEndpoints = retrofit.create(WeatherEndpoints.class);
  }

  public ForecastResponse getWeatherByPoints(double lat, double lon, String lang, String key) {
    Response<ResponseBody> response =
        WeatherManager.getWeatherByGeo(weatherEndpoints, lat, lon, lang, key);
    try {
      String rawResponseBody = response.body().string();
      return new Gson().fromJson(rawResponseBody, ForecastResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
