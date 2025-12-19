package tests.customers;

import apis.customers.CreateCustomerAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import providers.CustomerDataProvider;
import providers.FakerProvider;
import setUp.BaseTest;

import java.util.Map;

import static org.testng.Assert.*;

@Epic("Stripe API")
@Feature("Customers Test")
public class CreateCustomerTest extends BaseTest {
    @Story("Create customer with Valid Auth Key")
    @Test(dataProvider = "createCustomerSmallCases", dataProviderClass = CustomerDataProvider.class)
    public void validateCreateCustomerWithValidAuthKey(String caseName, Map<String, Object> formParams){
        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(formParams);
        assertEquals(response.statusCode(),200);
        String id = response.jsonPath().getString("id");
        Assert.assertNotNull(id);
        Assert.assertTrue(id.startsWith("cus_"));
        Assert.assertEquals(response.jsonPath().getString("object"), "customer");
    }

    @Story("Create customer with Data")
    @Test(dataProvider = "createCustomerCases", dataProviderClass = CustomerDataProvider.class)
    public void validateCreateCustomerWithData(String caseName, Map<String, Object> formParams){
        String email = (String) formParams.get("email");
        String name = (String) formParams.get("name");
        String description = (String) formParams.get("description");

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(formParams);
        assertEquals(response.statusCode(),200);
        String id = response.jsonPath().getString("id");
        Assert.assertNotNull(id);
        Assert.assertTrue(id.startsWith("cus_"));
        Assert.assertEquals(response.jsonPath().getString("object"), "customer");
        Assert.assertEquals(response.jsonPath().getString("email"), email);
        Assert.assertEquals(response.jsonPath().getString("name"), name);
        Assert.assertEquals(response.jsonPath().getString("description"), description);
    }

    @Story("Check Invalid Auth Key")
    @Test()
    public void invalidCreateCustomerWithInvalidAuthKey(){
        String email = FakerProvider.faker().internet().emailAddress();
        String name = FakerProvider.faker().name().fullName();
        String description = FakerProvider.faker().lorem().sentence(3);

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(name,email,description);
        assertEquals(response.statusCode(),401);
    }
}
