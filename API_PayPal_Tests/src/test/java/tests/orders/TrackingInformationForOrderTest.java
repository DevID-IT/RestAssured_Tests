package tests.orders;

import api.AuthAPI;
import api.OrderAPI;
import config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.orders.track.TrackOrder;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("PayPal API")
@Feature("Orders Test")
public class TrackingInformationForOrderTest extends BaseTest {
    @Story("Track order")
    @Test()
    public void addTrackingInformationForOrder(){
        String order_id = "9V095111WE3500709";
        String capture_id = "9GK287492V8474422";
        String access_token = AuthAPI.getAuthTokenRequest();

        TrackOrder track_order = new TrackOrder(capture_id, "443844607820", "FEDEX", "true");
        Response capture_response = OrderAPI.addTrackOrderInformation(access_token, order_id, track_order);
        Assert.assertEquals(capture_response.getStatusCode(), 200, "Status code is wrong");
        Assert.assertEquals(capture_response.jsonPath().getString("id"), order_id, "Id not match");
        Assert.assertEquals(capture_response.jsonPath().getString("intent"), "CAPTURE", "Intent is not capture");
        Assert.assertEquals(capture_response.jsonPath().getString("status"), "COMPLETED", "Status is not completed");
        Assert.assertEquals(capture_response.jsonPath().getString("purchase_units[0].payments.captures[0].id"), capture_id, "Capture is not present");
    }
}
