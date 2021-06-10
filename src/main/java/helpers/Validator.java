package helpers;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Validator {

    private Validator() {}

    public static Response<ResponseBody> execute(Call<ResponseBody> call) {
        Response<ResponseBody> response;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException("Unable to execute a call");
        }
        return response;
    }

    public static void checkContentType(Response response, ContentType expectedContentType) {
        if (expectedContentType != ContentType.NULL) {
            String actualContentType = response.raw().headers().get("Content-Type");
            if (actualContentType.contains(";")) {
                actualContentType = actualContentType.split(";")[0];
            }

            if (!actualContentType.equals(expectedContentType.getContentType())) {
                throw new RuntimeException(String.format("Actual response content type is %s, expected: %s", actualContentType, expectedContentType));
            }
        }

    }

    public static void checkCode(Response response, int expectedCode, String action) {
        int actualCode = response.raw().code();
        if (actualCode != expectedCode) {
            throw new RuntimeException(String.format("Unable to %s. Expected response code: %d, actual: %d", action, expectedCode, actualCode));
        }
    }

    public static Response<ResponseBody> validateResponse(Call<ResponseBody> call, int expectedCode, ContentType expectedContentType, String action) {
        Response response;
        try {
            response = call.execute();
        } catch (IOException var6) {
            throw new RuntimeException("IO Problem during execute API call. " + var6.getMessage());
        }

        checkCode(response, expectedCode, action);
        checkContentType(response, expectedContentType);
        return response;
    }
}
