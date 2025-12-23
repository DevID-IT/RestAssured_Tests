package helper;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PaymentApproveFlow {
    public static void ui_payment_approve(String approve_url) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();
            page.navigate(approve_url);
            page.getByText("Przetestuj zrealizowaną płatność").click();
            Thread.sleep(4000);
            browser.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
