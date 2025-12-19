package providers;

import testData.CustomerFormCases;
import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name = "createCustomerSmallCases", parallel = true)
    public static Object[][] createCustomerSmallCases() {
        return new Object[][]{
                {"email_only", CustomerFormCases.emailOnly()},
                {"email_name", CustomerFormCases.emailAndName()},
        };
    }
    @DataProvider(name = "createCustomerCases", parallel = true)
    public static Object[][] createCustomerCases() {
        return new Object[][]{
                {"full", CustomerFormCases.full()}
        };
    }
}