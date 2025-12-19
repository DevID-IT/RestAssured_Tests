package tests.customers;

import apis.customers.GetCustomersAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUp.BaseTest;

import java.util.List;
import java.util.Map;

@Epic("Stripe API")
@Feature("Customers Test")
public class GetCustomersTest extends BaseTest {

    @Story("Get all customers data")
    @Test()
    public void getCustomersDataTest() {
        Response response = GetCustomersAPI.sendPostRequestToGetCustomers();
        JSONObject jsonObject = new JSONObject(response.asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("object"), "list");
        Assert.assertEquals(response.jsonPath().getString("url"), "/v1/customers");
        Assert.assertTrue(jsonObject.has("data"), "Data key is not present in the JSON response");

        List<Map<String, Object>> dataListWithCustomers = response.jsonPath().getList("data");
        for (Map<String, Object> customer : dataListWithCustomers) {
            String id = (String) customer.get("id");
            Assert.assertNotNull(id, "No customer id");
            Assert.assertTrue(id.startsWith("cus_"));
        }
    }
}
