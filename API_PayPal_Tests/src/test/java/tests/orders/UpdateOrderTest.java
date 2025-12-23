package tests.orders;

import api.AuthAPI;
import api.OrderAPI;
import config.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.orders.update.AddressValue;
import model.orders.update.Operation;
import model.orders.create.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.orderDataProvider;

import java.util.ArrayList;

@Epic("PayPal API")
@Feature("Orders Test")
public class UpdateOrderTest extends BaseTest {
    @Story("Create order with valid form")
    @Test(dataProvider = "validDataProvider", dataProviderClass = orderDataProvider.class)
    public void updateOrder(String name, Orders order){
        String access_token = AuthAPI.getAuthTokenRequest();
        Response create_order = OrderAPI.createOrder(access_token, order);
        Assert.assertEquals(create_order.getStatusCode(), 201, "Status code is wrong");
        String order_id = create_order.jsonPath().getString("id");

        AddressValue value = new AddressValue("2211 N First Street", "Building 17", "San Jose", "CA", "95131", "US");
        Operation operation = new Operation("add", "/purchase_units/@reference_id=='A001'/shipping/address", value);
        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(operation);

        Response response = OrderAPI.updateOrder(access_token, order_id, operations);
        Assert.assertEquals(response.getStatusCode(), 204, "Status code is wrong");

        Response get_update_order = OrderAPI.getOrderDetails(access_token, order_id);
        boolean existedBefore = create_order.jsonPath().get("purchase_units[0].shipping") != null;
        boolean existsAfter = get_update_order.jsonPath().get("purchase_units[0].shipping") != null;
        Assert.assertFalse(existedBefore, "Shipping already exists before PATCH");
        Assert.assertTrue(existsAfter, "Shipping wasn't added with PATCH");
    }
}
