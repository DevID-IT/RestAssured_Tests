package tests.orders;

import api.AuthAPI;
import api.OrderAPI;
import config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.orders.confirm.*;
import model.orders.create.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.orderDataProvider;

@Epic("PayPal API")
@Feature("Orders Test")
public class ConfirmTheOrderTest extends BaseTest {
    @Story("Confirm order")
    @Test(dataProvider = "validDataProvider", dataProviderClass = orderDataProvider.class)
    public void confirmTheOrder(String case_name, Orders order){
        String access_token = AuthAPI.getAuthTokenRequest();
        Response create_order = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(create_order.getStatusCode(), 201, "Status code is wrong");
        String order_id = create_order.jsonPath().getString("id");

        ExperienceContext experience_context = new ExperienceContext(
                "EXAMPLE INC",
                "https://example.com/returnUrl",
                "https://example.com/cancelUrl"
        );
        String bank_name = "Pekao";
        String country_code = "IT";
        MyBank mybank = new MyBank(bank_name, country_code, experience_context);
        PaymentSource payment = new PaymentSource(mybank, "dawid@test.pl");
        ConfirmOrderRequest payment_source = new ConfirmOrderRequest(payment);

        Response response = OrderAPI.confirmPaymentForOrder(access_token, order_id, payment_source);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is wrong");
        Assert.assertEquals(response.jsonPath().getString("id"), order_id, "Order id is wrong");
        Assert.assertEquals(response.jsonPath().getString("status"), "PAYER_ACTION_REQUIRED", "Status didn't changed");
        Assert.assertEquals(response.jsonPath().getString("payment_source.mybank.name"), bank_name);
        Assert.assertEquals(response.jsonPath().getString("payment_source.mybank.country_code"), country_code);
    }
}
