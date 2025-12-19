package apis.customers;

import io.restassured.response.Response;
import setUp.BaseTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateCustomerAPI extends BaseTest {

    public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Map<String, Object> formParams) {
        return given().auth().basic(config.getProperty("validSecretKey"), "")
                .contentType("application/x-www-form-urlencoded")
                .formParams(formParams)
                .post(config.getProperty("customerAPIEndPoint"));
    }

    public static Response sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(String name, String email, String description) {
        return given().auth().basic(config.getProperty("inValidSecretKey"), "")
                .formParam("email", email).formParam("name", name).formParam("description", description)
                .post(config.getProperty("customerAPIEndPoint"));
    }
}
