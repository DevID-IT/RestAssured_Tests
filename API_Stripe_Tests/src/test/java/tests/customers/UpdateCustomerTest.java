package tests.customers;

import apis.customers.GetCustomersAPI;
import apis.customers.UpdateCustomerAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import providers.FakerProvider;
import setUp.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

@Epic("Stripe API")
@Feature("Customers Test")
public class UpdateCustomerTest extends BaseTest {
    String customerID = "";

    @BeforeMethod(onlyForGroups = "requiresCustomers")
    public void precondition() {
        Response getResponse = GetCustomersAPI.sendPostRequestToGetFirstCustomer();
        List<?> dataListWithCustomers = getResponse.jsonPath().getList("data");
        if (dataListWithCustomers != null && !dataListWithCustomers.isEmpty()) {
            customerID = getResponse.jsonPath().getString("data[0].id");
        } else {
            throw new SkipException("SKIP: no customer found");
        }
    }


    @Story("Update customer data")
    @Test(groups = "requiresCustomers")
    public void updateCustomerDataTest() {
        String email = FakerProvider.faker().internet().emailAddress();
        String name = FakerProvider.faker().name().fullName();
        String phoneNumber = FakerProvider.faker().phoneNumber().phoneNumber();

        Map<String, Object> formDataMap = new HashMap<>();
        formDataMap.put("email", email);
        formDataMap.put("name", name);
        formDataMap.put("phone", phoneNumber);

        Response response = UpdateCustomerAPI.updateCustomerDataTest(customerID, formDataMap);
        assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), customerID);
        Assert.assertEquals(response.jsonPath().getString("object"), "customer");
        Assert.assertEquals(response.jsonPath().getString("email"), email);
        Assert.assertEquals(response.jsonPath().getString("name"), name);
        Assert.assertEquals(response.jsonPath().getString("phone"), phoneNumber);
    }
}
