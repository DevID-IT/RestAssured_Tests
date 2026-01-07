package CucumberBDD.steps;

import CucumberBDD.base.BaseTestBDD;
import api.BDDAuthAPI;
import api.OrderAPI;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import testData.OrderFormCases;

import static org.hamcrest.Matchers.hasKey;

public class PayPalSteps {

	
    @Before
	public void setUp() {
        BaseTestBDD.init();
	}

	@Given("I want to get access token from PayPal api")
	public void i_want_to_get_access_token_from_PayPal_api() {
        BaseTestBDD.access_token = BDDAuthAPI.getAuthTokenRequestBDD();
	}

	@When("^I set currency code as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void i_set_currency_code_and_value(String currencyCode, String currencyValue) {

        BaseTestBDD.response = OrderAPI.createOrder(BaseTestBDD.access_token, OrderFormCases.validOrder());
	}
	
	
	@When("^I get order from the paypal api$")
	public void i_get_order_from_the_paypal_api() {

        BaseTestBDD.response = OrderAPI.getOrderDetails(BaseTestBDD.access_token, "71U66945FV187161D");
	}
	
	

	@And("^I verify the status as CREATED$")
	public void i_verify_the_status_as_created() {
        BaseTestBDD.response.then().body("$", hasKey("id"));
        Assert.assertEquals(BaseTestBDD.response.jsonPath().get("status"), "CREATED", "Status type is wrong");
	}
	
	
	@And("^I verify the status code as \"([^\"]*)\"$")
	public void i_verify_the_status_code_as(int statusCode) {
        Assert.assertEquals(BaseTestBDD.response.getStatusCode(), statusCode, "Status code is wrong");
	}
	
	
	
}
