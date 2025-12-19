package apis.customers;

import io.restassured.response.Response;
import setUp.BaseTest;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DeleteCustomerAPI extends BaseTest {

    public static Response sendPostRequestToDeleteCustomer(Hashtable<String, String> data) {
        return given().auth().basic(config.getProperty("validSecretKey"), "")
                .delete(config.getProperty("customerAPIEndPoint") + "/" + data.get("customerID"));
    }

}
