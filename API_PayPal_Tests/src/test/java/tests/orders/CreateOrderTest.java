package tests.orders;

import api.OrderAPI;
import config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import api.AuthAPI;
import model.orders.create.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.orderDataProvider;
import static org.hamcrest.Matchers.hasKey;

@Epic("PayPal API")
@Feature("Orders Test")
public class CreateOrderTest extends BaseTest {
    @Story("Create order with valid form")
    @Test(dataProvider = "validDataProvider", dataProviderClass = orderDataProvider.class)
    public void createNewOrderValid(String name, Orders order) {
        String access_token = AuthAPI.getAuthTokenRequest();
        Response response = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is wrong");
        response.then().body("$", hasKey("id"));
        Assert.assertEquals(response.jsonPath().get("status"), "CREATED", "Status type is wrong");
    }
    @Story("Create order - Validation errors")
    @Test(dataProvider = "invalidDataProvider", dataProviderClass = orderDataProvider.class)
    public void createNewOrderInvalid(String name, Orders order, String issue, String description) {
        String access_token = AuthAPI.getAuthTokenRequest();
        Response response = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(response.getStatusCode(), 422, "Status code is wrong");
        Assert.assertEquals(response.jsonPath().get("name"), "UNPROCESSABLE_ENTITY");
        Assert.assertEquals(response.jsonPath().get("details[0].issue"), issue, "Issue is wrong");
        Assert.assertEquals(response.jsonPath().get("details[0].description"), description, "Description is wrong");
        Assert.assertEquals(response.jsonPath().get("message"), "The requested action could not be performed, semantically incorrect, or failed business validation.");
    }
}
