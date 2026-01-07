package api;

import CucumberBDD.base.BaseTestBDD;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BDDAuthAPI extends BaseTestBDD {
    public static String getAuthTokenRequestBDD(){
        Response response = RestAssured.given()
                .param("grant_type", "client_credentials")
                .auth().preemptive().basic(client_id, secret)
                .post("/v1/oauth2/token");
        return response.jsonPath().get("access_token").toString();
    }
}
