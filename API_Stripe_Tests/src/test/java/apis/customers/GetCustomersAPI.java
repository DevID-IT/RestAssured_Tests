package apis.customers;

import io.restassured.response.Response;
import setUp.BaseTest;

import static io.restassured.RestAssured.given;

public class GetCustomersAPI extends BaseTest {

    public static Response sendPostRequestToGetFirstCustomer() {
        return given().auth().basic(config.getProperty("validSecretKey"), "")
                .get(config.getProperty("customerAPIEndPoint") + "?limit=1");
    }

    public static Response sendPostRequestToGetCustomers() {
        return given().auth().basic(config.getProperty("validSecretKey"), "")
                .get(config.getProperty("customerAPIEndPoint"));
    }


}
