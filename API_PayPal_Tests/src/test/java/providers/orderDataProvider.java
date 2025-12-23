package providers;

import org.testng.annotations.DataProvider;
import testData.OrderFormCases;

public class orderDataProvider {
    @DataProvider(name = "validDataProvider", parallel = true)
    public static Object[][] validDataProvider() {
        return new Object[][]{
                {"valid", OrderFormCases.validOrder()}
        };
    }
    @DataProvider(name = "invalidDataProvider", parallel = true)
    public static Object[][] invalidDataProvider() {
        String itemTotalDescription = "Should equal sum of (unit_amount * quantity) across all items for a given purchase_unit";
        String amountDescription = "Should equal item_total + tax_total + shipping + handling + insurance + gratuity - shipping_discount - discount.";


        return new Object[][]{
                {"invalidItemTotal", OrderFormCases.invalidOrderItemTotal(), "ITEM_TOTAL_MISMATCH", itemTotalDescription},
                {"invalidAmount", OrderFormCases.invalidOrderAmount(), "AMOUNT_MISMATCH", amountDescription},
                {"invalidShipping", OrderFormCases.invalidOrderShipping(), "AMOUNT_MISMATCH", amountDescription},
        };
    }
}
