package apis.customers;

import io.restassured.response.Response;
import setUp.BaseTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateCustomerAPI extends BaseTest {

    public static Response updateCustomerDataTest(String customerId, Map<String, Object> formParams) {
        return given().auth().basic(config.getProperty("validSecretKey"), "")
                .contentType("application/x-www-form-urlencoded")
                .formParams(formParams)
                .post(config.getProperty("customerAPIEndPoint") + "/" + customerId);
    }
}
