package tests.orders;

import api.AuthAPI;
import api.OrderAPI;
import config.BaseTest;
import helper.PaymentApproveFlow;
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
public class CapturePaymentForOrderTest extends BaseTest {
    @Story("Confirm payment order")
    @Test(dataProvider = "validDataProvider", dataProviderClass = orderDataProvider.class)
    public void capturePaymentForOrder(String case_name, Orders order){
        String access_token = AuthAPI.getAuthTokenRequest();
        Response create_order = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(create_order.getStatusCode(), 201, "Status code is wrong");
        String order_id = create_order.jsonPath().getString("id");

        ExperienceContext experience_context = new ExperienceContext(
                "EXAMPLE INC",
                "https://example.com/return",
                "https://example.com/approve"
        );
        MyBank mybank = new MyBank("Pekao", "IT", experience_context);
        PaymentSource payment = new PaymentSource(mybank, "dawid@test.pl");
        ConfirmOrderRequest payment_source = new ConfirmOrderRequest(payment);
        Response response = OrderAPI.confirmPaymentForOrder(access_token, order_id, payment_source);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is wrong");

        String approve_url = response.jsonPath().getString("links[1].href");
        PaymentApproveFlow.ui_payment_approve(approve_url);

        Response capture_response = OrderAPI.capturePaymentForOrder(access_token, order_id);
        Assert.assertEquals(capture_response.getStatusCode(), 201, "Status code is wrong");
        Assert.assertEquals(capture_response.jsonPath().getString("id"), order_id, "Id not match");
        Assert.assertEquals(capture_response.jsonPath().getString("status"), "COMPLETED", "Status is not completed");
    }
}
