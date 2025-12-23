package api;

import config.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthAPI extends BaseTest {
    public static String getAuthTokenRequest(){
        Response response = RestAssured.given()
                .param("grant_type", "client_credentials")
                .auth().preemptive().basic(config.getProperty("paypalClientID"), config.getProperty("paypalSecret"))
                .post("/v1/oauth2/token");
        return response.jsonPath().get("access_token").toString();
    }
}
