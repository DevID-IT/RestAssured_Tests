package tests.customers;

import apis.customers.DeleteCustomerAPI;
import apis.customers.GetCustomersAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setUp.BaseTest;

import java.util.Hashtable;
import java.util.List;


@Epic("Stripe API")
@Feature("Customers Test")
public class DeleteCustomerTest extends BaseTest {
    Hashtable<String, String> data;

    @BeforeMethod(onlyForGroups = "requiresCustomers")
    public void precondition() {
        Response getResponse = GetCustomersAPI.sendPostRequestToGetFirstCustomer();
        List<?> dataListWithCustomers = getResponse.jsonPath().getList("data");
        if (dataListWithCustomers != null && !dataListWithCustomers.isEmpty()) {
            String customerID = getResponse.jsonPath().getString("data[0].id");
            data = new Hashtable<>();
            data.put("customerID", customerID);
        } else {
            throw new SkipException("SKIP: no customer found");
        }
    }

    @Story("Delete random customer")
    @Test(groups = "requiresCustomers")
    public void deleteCustomerTest() {
        Response deleteResponse = DeleteCustomerAPI.sendPostRequestToDeleteCustomer(data);
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
        Assert.assertEquals(deleteResponse.jsonPath().getString("id"), data.get("customerID"), "ID dont match");
        Assert.assertEquals(deleteResponse.jsonPath().getString("object"), "customer", "Wrong object");
        Assert.assertEquals(deleteResponse.jsonPath().getString("deleted"), "true", "Customer not deleted");

    }

    @Story("Delete not existing customer")
    @Test
    public void deleteNotExistingCustomerTest() {
        Hashtable<String, String> data = new Hashtable<>();
        data.put("customerID", "cus_TcYBdP4HABkdBl");

        Response response = DeleteCustomerAPI.sendPostRequestToDeleteCustomer(data);
        JsonPath responseJson = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(responseJson.getString("error.code"), "resource_missing", "Niepoprawny error code");
        Assert.assertEquals(responseJson.getString("error.message"), "No such customer: '" + data.get("customerID") + "'", "Niepoprawna treść komunikatu");
    }
}
