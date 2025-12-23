package tests.orders;

import api.AuthAPI;
import api.OrderAPI;
import config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.orders.create.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.orderDataProvider;

@Epic("PayPal API")
@Feature("Orders Test")
public class GetOrderTest extends BaseTest {
    @Story("Get order details")
    @Test(dataProvider = "validDataProvider", dataProviderClass = orderDataProvider.class)
    public void getOrderDetailsTest(String name, Orders order) {
        String access_token = AuthAPI.getAuthTokenRequest();
        Response create_order = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(create_order.getStatusCode(), 201, "Status code is wrong");
        String order_id = create_order.jsonPath().getString("id");
        Response response = OrderAPI.getOrderDetails(access_token, order_id);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is wrong");
        Assert.assertEquals(response.jsonPath().getString("id"), order_id, "Order ID is wrong");
        Assert.assertEquals(response.jsonPath().getString("intent"), "CAPTURE");
        Assert.assertEquals(response.jsonPath().getString("status"), "CREATED");
        Assert.assertEquals(response.jsonPath().getString("purchase_units[0].invoice_id"), "test_invoice_id");
    }
}
